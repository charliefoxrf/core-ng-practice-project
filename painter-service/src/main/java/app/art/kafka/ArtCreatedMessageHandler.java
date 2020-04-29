package app.art.kafka;

import app.painter.api.art.kafka.ArtCreatedMessage;
import core.framework.kafka.MessageHandler;
import core.framework.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author charlie
 */
public class ArtCreatedMessageHandler implements MessageHandler<ArtCreatedMessage> {
    private final Logger logger = LoggerFactory.getLogger(ArtCreatedMessageHandler.class);

    @Override
    public void handle(String key, ArtCreatedMessage value) {
        logger.info(Strings.format("Art created message with name={} received by painter-service!", value.name));
    }
}
