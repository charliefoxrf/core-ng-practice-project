package app.painter;

import app.PainterDemoApp;
import core.framework.test.module.AbstractTestModule;

/**
 * @author charlie fox
 */
public class TestModule extends AbstractTestModule {
    @Override
    protected void initialize() {
        load(new PainterDemoApp());
    }
}
