package app.painter.web;

import app.painter.api.PainterWebService;
import app.painter.api.painter.BulkDeletePainterRequest;
import app.painter.api.painter.CreatePainterRequest;
import app.painter.api.painter.PainterView;
import app.painter.api.painter.SearchPainterRequest;
import app.painter.api.painter.SearchPainterResponse;
import app.painter.service.PainterService;
import core.framework.inject.Inject;

/**
 * @author charlie
 */
public class PainterWebServiceImpl implements PainterWebService {
    @Inject
    PainterService painterService;

    @Override
    public PainterView get(Long id) {
        return painterService.get(id);
    }

    @Override
    public PainterView create(CreatePainterRequest request) {
        return painterService.create(request);
    }

    @Override
    public PainterView update(Long id, CreatePainterRequest request) {
        return painterService.update(id, request);
    }

    @Override
    public SearchPainterResponse search(SearchPainterRequest request) {
        return painterService.search(request);
    }

    @Override
    public void bulkDelete(BulkDeletePainterRequest request) {
        painterService.bulkDelete(request);
    }
}
