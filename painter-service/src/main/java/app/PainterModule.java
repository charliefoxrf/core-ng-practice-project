package app;

import app.painter.Brush;
import app.painter.Painter;
import core.framework.module.Module;

/**
 * @author charlie
 */
public class PainterModule extends Module {

    @Override
    protected void initialize() {
        bind(Brush.class);
        bind(Painter.class);
        Painter painter = bean(Painter.class);
        onStartup(painter::draw);
    }
}
