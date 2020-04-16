package app.painter.api.painter;

import core.framework.api.json.Property;
import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;

public class BulkDeletePainterRequest {
    @NotBlank
    @NotNull
    @Property(name = "first_name")
    public String firstName;

}
