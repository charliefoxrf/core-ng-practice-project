package app.painter.service;

import app.painter.api.painter.BulkDeletePainterRequest;
import app.painter.api.painter.CreatePainterRequest;
import app.painter.api.painter.PainterView;
import app.painter.api.painter.SearchPainterRequest;
import app.painter.api.painter.SearchPainterResponse;
import app.painter.domain.Painter;
import core.framework.async.Executor;
import core.framework.db.Database;
import core.framework.db.Query;
import core.framework.db.Repository;
import core.framework.db.Transaction;
import core.framework.inject.Inject;
import core.framework.util.Strings;
import core.framework.web.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author charlie
 */
public class PainterService {
    private final Logger logger = LoggerFactory.getLogger(PainterService.class);
    @Inject
    Repository<Painter> painterRepository;
    @Inject
    Database database;
    @Inject
    Executor executor;

    public PainterView get(Long id) {
        Painter painter = getPainterOrThrow(id);
        return view(painter);
    }

    public PainterView create(CreatePainterRequest request) {
        Painter painter = new Painter();
        painter.firstName = request.firstName;
        painter.lastName = request.lastName;
        painter.id = painterRepository.insert(painter).orElseThrow();
        executor.submit("normal-task", () -> {
            logger.info("Painter created!");
        });
        executor.submit("delayed-task", () -> {
            logger.info("Painter created about 10s ago!");
        }, Duration.ofSeconds(10));
        return view(painter);
    }

    public PainterView update(Long id, CreatePainterRequest request) {
        Painter painter = getPainterOrThrow(id);
        painter.firstName = request.firstName;
        painter.lastName = request.lastName;
        painterRepository.update(painter);
        return view(painter);
    }

    public SearchPainterResponse search(SearchPainterRequest request) {
        SearchPainterResponse result = new SearchPainterResponse();
        Query<Painter> query = painterRepository.select();
        query.skip(request.skip);
        query.limit(request.limit);
        query.where("first_name = ?", request.firstName);
        result.painters = query.fetch().stream().map(this::view).collect(Collectors.toList());
        result.total = query.count();
        return result;
    }

    public void bulkDelete(BulkDeletePainterRequest request) {
        Query<Painter> query = painterRepository.select();
        query.where("first_name = ?", request.firstName);
        List<Long> painterIds = query.fetch().stream().map(painter -> painter.id).collect(Collectors.toList());
        try (Transaction transaction = database.beginTransaction()) {
            painterRepository.batchDelete(painterIds);
            // delete some attached resource here
            transaction.commit();
        }
    }


    private Painter getPainterOrThrow(Long id) {
        return painterRepository.get(id).orElseThrow(() -> new NotFoundException(Strings.format("art not found, id={}", id)));
    }

    private PainterView view(Painter painter) {
        PainterView painterView = new PainterView();
        painterView.id = painter.id;
        painterView.firstName = painter.firstName;
        painterView.lastName = painter.lastName;
        return painterView;
    }
}
