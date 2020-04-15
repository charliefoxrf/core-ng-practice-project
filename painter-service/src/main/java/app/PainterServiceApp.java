package app;

import core.framework.module.App;
import core.framework.module.SystemModule;

/**
 * @author charlie
 */
public class PainterServiceApp extends App {

    @Override
    protected void initialize() {
        http().httpPort(8081);

        load(new SystemModule("sys.properties"));
        load(new PainterModule());
    }
}
