package app.painter.api;

import app.painter.api.painter.BulkDeletePainterRequest;
import app.painter.api.painter.CreatePainterRequest;
import app.painter.api.painter.PainterView;
import app.painter.api.painter.SearchPainterRequest;
import app.painter.api.painter.SearchPainterResponse;
import core.framework.api.http.HTTPStatus;
import core.framework.api.web.service.GET;
import core.framework.api.web.service.POST;
import core.framework.api.web.service.PUT;
import core.framework.api.web.service.Path;
import core.framework.api.web.service.PathParam;
import core.framework.api.web.service.ResponseStatus;

/**
 * @author charlie
 */
public interface PainterWebService {
    @GET
    @Path("/painter/:id")
    PainterView get(@PathParam("id") Long id);

    @POST
    @Path("/painter")
    @ResponseStatus(HTTPStatus.CREATED)
    PainterView create(CreatePainterRequest request);

    @PUT
    @Path("/painter/:id")
    PainterView update(@PathParam("id") Long id, CreatePainterRequest request);

    @GET
    @Path("/painter")
    SearchPainterResponse search(SearchPainterRequest request);

    @POST
    @Path("/painter/bulk")
    void bulkDelete(BulkDeletePainterRequest request);
}
