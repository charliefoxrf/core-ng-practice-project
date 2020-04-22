package app;

import app.art.domain.Art;
import app.art.job.ArtDailyJob;
import app.art.job.ArtFixedJob;
import app.art.job.ArtTriggerJob;
import app.art.kafka.ArtCreatedMessageHandler;
import app.art.service.ArtService;
import app.art.web.ArtWebServiceImpl;
import app.painter.api.ArtWebService;
import app.painter.api.art.kafka.ArtCreatedMessage;
import core.framework.module.Module;
import core.framework.mongo.module.MongoConfig;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author charlie
 */
public class ArtModule extends Module {
    @Override
    protected void initialize() {
        kafka().groupId("painter-service");
        kafka().publish("art-created", ArtCreatedMessage.class);
        kafka().subscribe("art-created", ArtCreatedMessage.class, bind(ArtCreatedMessageHandler.class));

        MongoConfig config = config(MongoConfig.class);
        config.uri(requiredProperty("sys.mongo.uri"));
        config.collection(Art.class);
        bind(ArtService.class);
        api().service(ArtWebService.class, bind(ArtWebServiceImpl.class));

        schedule().fixedRate("art-fixed", bind(ArtFixedJob.class), Duration.ofMinutes(1));
        schedule().dailyAt("art-daily", bind(ArtDailyJob.class), LocalTime.NOON);
        schedule().trigger("art-trigger", bind(ArtTriggerJob.class), previous -> {
            return previous.plusSeconds(10 + ThreadLocalRandom.current().nextInt(-3, 4));
        });
    }
}
