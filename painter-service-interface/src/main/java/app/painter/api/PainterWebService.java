package app.painter.api;

import app.painter.api.painter.CreatePainterRequest;
import app.painter.api.painter.PainterView;
import core.framework.api.http.HTTPStatus;
import core.framework.api.web.service.POST;
import core.framework.api.web.service.Path;
import core.framework.api.web.service.ResponseStatus;

/**
 * @author charlie
 */
public interface PainterWebService {

    @POST
    @Path("/painter")
    @ResponseStatus(HTTPStatus.CREATED)
    PainterView create(CreatePainterRequest request);

}
