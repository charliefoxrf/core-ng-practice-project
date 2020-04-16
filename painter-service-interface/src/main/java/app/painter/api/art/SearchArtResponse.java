package app.painter.api.art;

import core.framework.api.json.Property;

import java.util.List;

/**
 * @author charlie
 */
public class SearchArtResponse {
    @Property(name = "total")
    public Long total;

    @Property(name = "art")
    public List<ArtView> art;
}
