package app;

import core.framework.module.App;

/**
 * @author charlie
 */
public class PainterDemoApp extends App {

    @Override
    protected void initialize() {
        http().httpPort(8081);

        load(new PainterModule());
    }
}
