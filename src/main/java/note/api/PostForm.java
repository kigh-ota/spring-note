package note.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
class PostForm {
    @JsonProperty("title")
    @NotEmpty
    private String title;

    @JsonProperty("body")
    private String body;
}
