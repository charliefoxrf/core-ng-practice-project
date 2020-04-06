package app;

import app.painter.demo.Painter;
import app.painter.demo.Brush;
import core.framework.module.Module;

/**
 * @author charlie
 */
public class PainterModule extends Module {

    @Override
    protected void initialize() {
        bind(Brush.class);
        bind(Painter.class);
        bean(Painter.class).draw();
    }
}
