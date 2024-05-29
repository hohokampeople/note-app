package note.app.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import note.app.model.Note;
import note.app.model.Response;
import note.app.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private static final String NO_RECORD_FOUND_MSG = "Record not found for the given ID: {0}. Please check the ID and try again.";
    private static final String EMPTY_RECORDS_MSG = "No records.";
    private static final String DELETE_RECORD_MSG = "Record successfully deleted.";

    @Autowired
    private NoteService noteService;

    @Tag(name = "get", description = "Retrieve all notes.")
    @GetMapping
    public ResponseEntity<Response> getNotes() {
        final Response response = new Response();
        final List<Note> notes = noteService.getNotes();
        if (!CollectionUtils.isEmpty(notes)) {
            response.setNotes(noteService.getNotes());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.setMessage(EMPTY_RECORDS_MSG);
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        }
    }

    @Tag(name = "get", description = "Retrieve a specific note by ID.")
    @GetMapping("/{id}")
    public ResponseEntity<Response> getNoteById(@PathVariable final int id) {
        final Response response = new Response();
        final Optional<Note> note = noteService.getNote(id);
        if (note.isPresent()) {
            response.setNote(note.get());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.setMessage(MessageFormat.format(NO_RECORD_FOUND_MSG, id));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @Tag(name = "post", description = "Create a new note.")
    @PostMapping
    public Note save(@RequestBody final Note note) {
        return noteService.save(note);
    }

    @Tag(name = "put", description = "Update a specific note.")
    @PutMapping("/{id}")
    public ResponseEntity<Response> update(@PathVariable int id, @RequestBody Note note) {
        final Response response = new Response();
        final Optional<Note> noteData = noteService.getNote(id);
        if (noteData.isPresent()) {
            final Note existingNote = noteData.get();
            existingNote.setTitle(note.getTitle());
            existingNote.setBody(note.getBody());
            response.setNote(existingNote);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.setMessage(MessageFormat.format(NO_RECORD_FOUND_MSG, id));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @Tag(name = "delete", description = "Delete a specific note.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable int id) {
        final Response response = new Response();
        final Optional<Note> note = noteService.getNote(id);
        if (note.isPresent()) {
            noteService.delete(id);
            response.setMessage(DELETE_RECORD_MSG);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.setMessage(MessageFormat.format(NO_RECORD_FOUND_MSG, id));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
