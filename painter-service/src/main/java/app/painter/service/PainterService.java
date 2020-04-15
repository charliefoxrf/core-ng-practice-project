package app.painter.service;

import app.painter.api.painter.CreatePainterRequest;
import app.painter.api.painter.PainterView;
import app.painter.domain.Painter;
import core.framework.db.Repository;
import core.framework.inject.Inject;

/**
 * @author charlie
 */
public class PainterService {

    @Inject
    Repository<Painter> painterRepository;

    public PainterView create(CreatePainterRequest request) {
        Painter painter = new Painter();
        painter.firstName = request.firstName;
        painter.lastName = request.lastName;
        painter.id = painterRepository.insert(painter).orElseThrow();
        return view(painter);
    }

    public PainterView view(Painter painter) {
        PainterView painterView = new PainterView();
        painterView.id = painter.id;
        painterView.firstName = painter.firstName;
        painterView.lastName = painter.lastName;
        return painterView;
    }

}
