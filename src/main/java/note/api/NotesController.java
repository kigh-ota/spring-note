package note.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import note.domain.model.NoteRepository;
import note.domain.model.note.Note;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("notes")
public class NotesController {

    private final NoteRepository noteRepository;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<NoteResource> getNotes() {
        return noteRepository.findAll().stream().map(note -> new NoteResource(note)).collect(Collectors.toList());
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<Void> postNotes(@RequestBody PostForm form) {
        Note note = createNote(form.getTitle(), form.getBody());
        return ResponseEntity.created(URI.create("http://localhost:8080/notes/" + note.getId())).build();
    }

    @RequestMapping(path = "", method = RequestMethod.PUT)
    public ResponseEntity<Void> putNotes(@RequestBody PutForm form) {
        Note note = null;
        try {
            int id = Integer.parseInt(form.getId());
            note = noteRepository.findOne(id);
        } catch (NumberFormatException e) {
            // no valid id specified
        }
        if (note == null) {
            // create
            note = createNote(form.getTitle(), form.getBody());
            return ResponseEntity.created(URI.create("http://localhost:8080/notes/" + note.getId())).build();
        } else {
            // update
            note.setTitle(form.getTitle()).setBody(form.getBody());
            noteRepository.save(note);
            return ResponseEntity.noContent().build();
        }
    }

    private Note createNote(String title, String body) {
        Note note = new Note().setTitle(title).setBody(title);
        return noteRepository.save(note);
    }

    @Getter
    @Setter
    class NoteResource  {
        private String id;
        private String title;
        private String body;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        NoteResource(Note note) {
            id = Integer.toString(note.getId());
            title = note.getTitle().getTitle();
            body = note.getBody().getBody();
            createdAt = note.getCreatedAt();
            updatedAt = note.getUpdatedAt();
        }
    }
}
