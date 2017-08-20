package note;

import note.domain.model.note.Note;

import java.sql.Timestamp;

public class NoteUtil {

    static public Note createNote(Integer id, String title, String body, Timestamp createdAt, Timestamp updatedAt) {
        Note note = new Note();
        note.setId(id);
        note.setTitle(title).setBody(body);
        note.setCreatedAt(createdAt);
        note.setUpdatedAt(updatedAt);
        return note;
    }

}
