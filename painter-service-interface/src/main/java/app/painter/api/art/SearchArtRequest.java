package app.painter.api.art;

import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;
import core.framework.api.web.service.QueryParam;

/**
 * @author charlie
 */
public class SearchArtRequest {
    @NotNull
    @QueryParam(name = "skip")
    public Integer skip = 0;

    @NotNull
    @QueryParam(name = "limit")
    public Integer limit = 1000;

    @NotNull
    @NotBlank
    @QueryParam(name = "term")
    public String term;
}
