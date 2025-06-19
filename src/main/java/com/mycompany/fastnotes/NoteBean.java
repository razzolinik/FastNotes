package com.mycompany.fastnotes;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Named("noteBean")
@SessionScoped
@Transactional
public class NoteBean implements Serializable {

    @PersistenceContext(unitName = "FastNotesPU")
    private EntityManager em;

    private Note note = new Note();
    private String search = "";
    private boolean showArchived = false;

    // Obtener lista de notas (activas o archivadas), filtradas por búsqueda
    public List<Note> getNotes() {
        String jpql = "SELECT n FROM Note n WHERE n.archived = :archived";
        TypedQuery<Note> query = em.createQuery(jpql, Note.class);
        query.setParameter("archived", showArchived);
        List<Note> results = query.getResultList();

        if (search != null && !search.isEmpty()) {
            String filter = search.toLowerCase();
            results.removeIf(n -> !n.getTitle().toLowerCase().contains(filter));
        }

        return results;
    }

    // Guardar o actualizar nota
    public String save() {
        if (note.getId() == null) {
            em.persist(note);
        } else {
            em.merge(note);
        }
        note = new Note();
        return "notesPage.xhtml?faces-redirect=true";
    }

    public String edit(Note n) {
        this.note = n;
        return "newNotePage.xhtml?faces-redirect=true";
    }

    public void delete(Note n) {
        Note toDelete = em.find(Note.class, n.getId());
        if (toDelete != null) {
            em.remove(toDelete);
        }
    }

    // Alternar entre mostrar archivadas o activas
    public void toggleArchivedView() {
        showArchived = !showArchived;
    }

    // Alternar estado de una nota (archivar/desarchivar)
    public void toggleArchive(Note n) {
        n.setArchived(!n.isArchived());
        em.merge(n);
    }

    public String getToday() {
        return java.time.LocalDate.now().toString();
    }

    // Getters y setters
    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public boolean getShowArchived() {
        return showArchived;
    }

    public void setShowArchived(boolean showArchived) {
        this.showArchived = showArchived;
    }
}
