package app.art.web;

import app.art.service.ArtService;
import app.painter.api.ArtWebService;
import app.painter.api.art.ArtView;
import app.painter.api.art.CreateArtRequest;
import app.painter.api.art.SearchArtRequest;
import app.painter.api.art.SearchArtResponse;
import core.framework.inject.Inject;
import core.framework.log.ActionLogContext;

/**
 * @author charlie
 */
public class ArtWebServiceImpl implements ArtWebService {
    @Inject
    ArtService artService;

    @Override
    public ArtView get(String id) {
        ActionLogContext.put("artId", id);
        return artService.get(id);
    }

    @Override
    public ArtView create(CreateArtRequest request) {
        ArtView response = artService.create(request);
        ActionLogContext.put("artId", response.id);
        return response;
    }

    @Override
    public SearchArtResponse search(SearchArtRequest request) {
        return artService.search(request);
    }
}
