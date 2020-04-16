package app;

import app.art.domain.Art;
import app.art.service.ArtService;
import app.art.web.ArtWebServiceImpl;
import app.painter.api.ArtWebService;
import core.framework.module.Module;
import core.framework.mongo.module.MongoConfig;

/**
 * @author charlie
 */
public class ArtModule extends Module {
    @Override
    protected void initialize() {
        MongoConfig config = config(MongoConfig.class);
        config.uri(requiredProperty("sys.mongo.uri"));
        config.collection(Art.class);
        bind(ArtService.class);
        api().service(ArtWebService.class, bind(ArtWebServiceImpl.class));
    }
}
