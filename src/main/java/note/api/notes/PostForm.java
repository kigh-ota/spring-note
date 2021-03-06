package note.api.notes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
@AllArgsConstructor // for testing
class PostForm {
    @JsonProperty("title")
    @NotEmpty
    private String title;

    @JsonProperty("body")
    private String body;
}
