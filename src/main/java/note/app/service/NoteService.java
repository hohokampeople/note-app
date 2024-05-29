package note.app.service;

import note.app.model.Note;
import note.app.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public List<Note> getNotes() {
       return noteRepository.getNotes();
    }

    public Optional<Note> getNote(final int id) {
       return noteRepository.getNote(id);
    }

    public Note save(final Note note) {
       return noteRepository.save(note);
    }

    public Note update(final Note note) {
       return noteRepository.update(note);
    }

    public void delete(final int id) {
        noteRepository.delete(id);
    }
}
