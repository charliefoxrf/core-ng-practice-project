package app.art.web;

import app.art.service.ArtService;
import app.painter.api.ArtWebService;
import app.painter.api.art.ArtView;
import app.painter.api.art.CreateArtRequest;
import core.framework.inject.Inject;

/**
 * @author charlie
 */
public class ArtWebServiceImpl implements ArtWebService {
    @Inject
    ArtService artService;

    @Override
    public ArtView get(String id) {
        return artService.get(id);
    }

    @Override
    public ArtView create(CreateArtRequest request) {
        return artService.create(request);
    }
}
