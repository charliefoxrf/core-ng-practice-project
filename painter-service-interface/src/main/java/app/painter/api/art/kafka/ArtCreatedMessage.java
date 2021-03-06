package app.painter.api.art.kafka;

import core.framework.api.json.Property;
import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;

/**
 * @author charlie
 */
public class ArtCreatedMessage {
    @NotNull
    @NotBlank
    @Property(name = "name")
    public String name;
}
