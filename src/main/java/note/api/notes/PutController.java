package note.api.notes;

import lombok.RequiredArgsConstructor;
import note.application.NoteService;
import note.domain.model.note.Note;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class PutController {

    private final NoteService noteService;

    @RequestMapping(path = "notes", method = RequestMethod.PUT)
    public ResponseEntity<Void> putNotes(@RequestBody PutForm form) {
        Integer id = strToInt(form.getId());
        if (id == null) {
            Note note = noteService.add(form.getTitle(), form.getBody());
            return ResponseEntity.created(URI.create("http://localhost:8080/notes/" + note.getId())).build();
        } else {
            noteService.update(id, form.getTitle(), form.getBody());
            return ResponseEntity.noContent().build();
        }
    }

    private Integer strToInt(String s) {
        try {
            return Integer.valueOf(s);
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
