package note.application;

import lombok.RequiredArgsConstructor;
import note.domain.model.NoteRepository;
import note.domain.model.note.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public Note get(Integer id) {
        if (id == null) {
            return null;
        }
        return noteRepository.findOne(id);
    }

    public List<Note> getAll() {
        return noteRepository.findAll();
    }

    public Note add(String title, String body) {
        Note note = new Note().setTitle(title).setBody(title);
        return noteRepository.save(note);
    }

    public void update(int id, String title, String body) {
        Note note = noteRepository.findOne(id);
        if (note == null) {
            throw new RuntimeException();
        }
        note.setTitle(title).setBody(body);
        noteRepository.save(note);
    }

}
