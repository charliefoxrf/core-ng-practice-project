package app;

import app.painter.api.PainterWebService;
import app.painter.domain.Painter;
import app.painter.service.PainterService;
import app.painter.web.PainterWebServiceImpl;
import core.framework.module.Module;

/**
 * @author charlie
 */
public class PainterModule extends Module {

    @Override
    protected void initialize() {
        db().repository(Painter.class);
        bind(PainterService.class);
        api().service(PainterWebService.class, bind(PainterWebServiceImpl.class));
    }
}
