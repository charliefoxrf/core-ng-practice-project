package app.painter.api.painter;

import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;
import core.framework.api.web.service.QueryParam;

/**
 * @author charlie
 */
public class SearchPainterRequest {

    @NotNull
    @QueryParam(name = "skip")
    public Integer skip = 0;

    @NotNull
    @QueryParam(name = "limit")
    public Integer limit = 1000;

    @NotNull
    @NotBlank
    @QueryParam(name = "first_name")
    public String firstName;
}
