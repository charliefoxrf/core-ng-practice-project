package app.painter.api.painter;

import core.framework.api.json.Property;

import java.util.List;

/**
 * @author charlie
 */
public class SearchPainterResponse {

    @Property(name = "total")
    public Long total;

    @Property(name = "painters")
    public List<PainterView> painters;
}
