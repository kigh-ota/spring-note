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
public class PostController {

    private final NoteService noteService;

    @RequestMapping(path = "notes", method = RequestMethod.POST)
    public ResponseEntity<Void> post(@RequestBody PostForm form) {
        Note note = noteService.add(form.getTitle(), form.getBody());
        return ResponseEntity.created(URI.create("http://localhost:8080/notes/" + note.getId())).build();
    }

}
