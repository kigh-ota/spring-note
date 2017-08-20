package note.api;

import lombok.Getter;
import lombok.Setter;
import note.domain.model.note.Note;

import java.util.Date;

@Getter
@Setter
public class NoteResource  {
    private String id;
    private String title;
    private String body;
    private Date createdAt;
    private Date updatedAt;

    public NoteResource(Note note) {
        id = Integer.toString(note.getId());
        title = note.getTitle().getTitle();
        body = note.getBody().getBody();
        createdAt = note.getCreatedAt();
        updatedAt = note.getUpdatedAt();
    }
}
