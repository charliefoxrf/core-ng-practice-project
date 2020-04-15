package app.painter.domain;

import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;
import core.framework.db.Column;
import core.framework.db.PrimaryKey;
import core.framework.db.Table;

/**
 * @author charlie
 */
@Table(name = "painters")
public class Painter {

    @PrimaryKey(autoIncrement = true)
    @Column(name = "id")
    public Long id;

    @NotNull
    @NotBlank
    @Column(name = "first_name")
    public String firstName;

    @NotNull
    @NotBlank
    @Column(name = "last_name")
    public String lastName;
}
