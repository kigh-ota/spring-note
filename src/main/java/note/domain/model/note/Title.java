package note.domain.model.note;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import note.domain.model.ValueObject;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Title extends ValueObject {

    @NotBlank
    private String title = "";

}
