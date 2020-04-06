package app.painter;

import core.framework.test.Context;
import core.framework.test.IntegrationExtension;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * @author charlie
 */
@ExtendWith(IntegrationExtension.class)
@Context(module = TestModule.class)
public class IntegrationTest {
    protected IntegrationTest() {
    }
}
