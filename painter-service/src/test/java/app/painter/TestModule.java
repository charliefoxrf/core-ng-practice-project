package app.painter;

import app.PainterServiceApp;
import core.framework.test.module.AbstractTestModule;

/**
 * @author charlie
 */
public class TestModule extends AbstractTestModule {
    @Override
    protected void initialize() {
        load(new PainterServiceApp());
    }
}
