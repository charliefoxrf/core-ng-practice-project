package app.painter;

import app.PainterDemoApp;
import core.framework.test.module.AbstractTestModule;

/**
 * @author charlie
 */
public class TestModule extends AbstractTestModule {
    @Override
    protected void initialize() {
        load(new PainterDemoApp());
    }
}
