package note.domain.model.note;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

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
    @Setter // for testing
    // TODO: change type to LocalDateTime when Hibernate version that Spring Boot uses becomes 5.2.3+
    private Timestamp createdAt;

    @UpdateTimestamp
    @Setter // for testing
    private Timestamp updatedAt;

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
