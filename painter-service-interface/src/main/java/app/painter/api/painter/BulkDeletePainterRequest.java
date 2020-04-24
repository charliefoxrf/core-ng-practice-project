package app.painter.api.painter;

import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;
import core.framework.api.web.service.QueryParam;

public class BulkDeletePainterRequest {
    @NotBlank
    @NotNull
    @QueryParam(name = "first_name")
    public String firstName;

}
