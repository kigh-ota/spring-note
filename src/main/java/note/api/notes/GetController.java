package note.api.notes;

import lombok.RequiredArgsConstructor;
import note.api.NoteResource;
import note.application.NoteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class GetController {

    private final NoteService noteService;

    @RequestMapping(path = "notes", method = RequestMethod.GET)
    public List<NoteResource> get() {
        return noteService.getAll().stream().map(note -> new NoteResource(note)).collect(Collectors.toList());
    }

    // TODO: add getSingle() for /notes/{id}
}
