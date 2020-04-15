package app.painter.api.art;

import core.framework.api.json.Property;
import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;

/**
 * @author charlie
 */
public class ArtView {

    @NotNull
    @Property(name = "id")
    public String id;

    @NotNull
    @NotBlank
    @Property(name = "name")
    public String name;
}
