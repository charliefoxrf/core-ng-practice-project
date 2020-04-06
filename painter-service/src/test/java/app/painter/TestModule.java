package app.painter;

import app.PainterDemoApp;
import core.framework.test.module.AbstractTestModule;

/**
 * @author neo
 */
public class TestModule extends AbstractTestModule {
    @Override
    protected void initialize() {
        load(new PainterDemoApp());
    }
}
