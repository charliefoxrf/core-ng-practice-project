package app.painter.web;

import app.painter.api.PainterWebService;
import app.painter.api.painter.BulkDeletePainterRequest;
import app.painter.api.painter.CreatePainterRequest;
import app.painter.api.painter.PainterView;
import app.painter.api.painter.SearchPainterRequest;
import app.painter.api.painter.SearchPainterResponse;
import app.painter.service.PainterService;
import core.framework.inject.Inject;
import core.framework.log.ActionLogContext;

/**
 * @author charlie
 */
public class PainterWebServiceImpl implements PainterWebService {
    @Inject
    PainterService painterService;

    @Override
    public PainterView get(Long id) {
        ActionLogContext.put("painterId", id);
        return painterService.get(id);
    }

    @Override
    public PainterView create(CreatePainterRequest request) {
        PainterView response = painterService.create(request);
        ActionLogContext.put("painterId", response.id);
        return response;
    }

    @Override
    public PainterView update(Long id, CreatePainterRequest request) {
        ActionLogContext.put("painterId", id);
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
