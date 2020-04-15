package app.painter.web;

import app.painter.api.PainterWebService;
import app.painter.api.painter.CreatePainterRequest;
import app.painter.api.painter.PainterView;
import app.painter.service.PainterService;
import core.framework.inject.Inject;

/**
 * @author charlie
 */
public class PainterWebServiceImpl implements PainterWebService {

    @Inject
    PainterService painterService;

    @Override
    public PainterView create(CreatePainterRequest request) {
        return painterService.create(request);
    }
}
