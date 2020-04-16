package app.painter.api;

import app.painter.api.art.ArtView;
import app.painter.api.art.CreateArtRequest;
import core.framework.api.http.HTTPStatus;
import core.framework.api.web.service.GET;
import core.framework.api.web.service.POST;
import core.framework.api.web.service.Path;
import core.framework.api.web.service.PathParam;
import core.framework.api.web.service.ResponseStatus;

/**
 * @author charlie
 */
public interface ArtWebService {
    @GET
    @Path("/art/:id")
    ArtView get(@PathParam("id") String id);

    @POST
    @Path("/art")
    @ResponseStatus(HTTPStatus.CREATED)
    ArtView create(CreateArtRequest request);

}
