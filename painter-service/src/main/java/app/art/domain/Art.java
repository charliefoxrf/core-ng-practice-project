package app.art.domain;

import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;
import core.framework.mongo.Collection;
import core.framework.mongo.Field;
import core.framework.mongo.Id;

/**
 * @author charlie
 */
@Collection(name = "art")
public class Art {

    @Id
    public String id;

    @NotNull
    @NotBlank
    @Field(name = "name")
    public String name;

}
