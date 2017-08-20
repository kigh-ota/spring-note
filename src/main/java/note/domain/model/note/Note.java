package note.domain.model.note;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "note")
@NoArgsConstructor
@Getter
public class Note extends note.domain.model.Entity {

    @Id
    @GeneratedValue
    @Setter // for testing
    private Integer id;

    private Title title;

    private Body body;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Note setTitle(String title) {
        this.title = new Title(title);
        return this;
    }

    public Note setBody(String body) {
        this.body = new Body(body);
        return this;
    }

    // TODO: add getTags()
}
