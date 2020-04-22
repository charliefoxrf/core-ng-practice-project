package app;

import app.kafka.ArtCreatedMessageHandler;
import app.painter.api.art.kafka.ArtCreatedMessage;
import core.framework.module.App;
import core.framework.module.SystemModule;

/**
 * @author charlie
 */
public class CustomerServiceApp extends App {
    @Override
    protected void initialize() {
        http().httpPort(8080);

        load(new SystemModule("sys.properties"));
        kafka().groupId("customer-service");
        kafka().subscribe("art-created", ArtCreatedMessage.class, bind(ArtCreatedMessageHandler.class));
    }
}
