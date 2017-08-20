package note.api.notes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
class PutForm {
    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    @NotEmpty
    private String title;

    @JsonProperty("body")
    private String body;
}