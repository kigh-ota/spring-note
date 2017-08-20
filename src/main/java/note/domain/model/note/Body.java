package note.domain.model.note;

import com.google.common.collect.ImmutableList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import note.domain.model.ValueObject;
import org.hibernate.annotations.Type;

import javax.persistence.Embeddable;
import java.util.List;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Body extends ValueObject {

    @Type(type = "text")
    private String body = "";

    List<Tag> getTags() {
        return ImmutableList.of();
    }
}
