package note.app.repository;

import note.app.model.Note;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class NoteRepository {

    private final List<Note> notes = new ArrayList<>();
    private final AtomicInteger counter = new AtomicInteger();

    public List<Note> getNotes() {
        return new ArrayList<>(notes);
    }

    public Optional<Note> getNote(final int id) {
        return notes.stream().filter(n -> n.getId() == id).findFirst();
    }

    public Note save(final Note note) {
        note.setId(counter.incrementAndGet());
        notes.add(note);
        return note;
    }

    public Note update(final Note note) {
        notes.removeIf(n -> n.getId() == note.getId());
        notes.add(note);
        return note;
    }

    public void delete(final int id) {
        notes.removeIf(n -> n.getId() == id);
    }
}
