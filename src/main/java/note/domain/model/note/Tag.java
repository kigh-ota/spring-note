package note.domain.model.note;

import note.domain.model.ValueObject;
import org.hibernate.validator.constraints.NotBlank;

class Tag extends ValueObject {

    @NotBlank
    private String name;

}
