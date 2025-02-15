package mandy.app;

import java.util.ArrayList;

public class NoteKeeper {
    private ArrayList<Note> noteList;

    public NoteKeeper() {
        this.noteList = new ArrayList<>();
    }

    public NoteKeeper(ArrayList<Note> notes) {
        this.noteList = notes;
    }

    public void addNote(String s) {
        noteList.add(new Note(s));
    }

    public void printNotes() {
        for (int i = 1; i <= noteList.size(); i++) {
            System.out.println(i + ". " + noteList.get(i-1).getNote());
        }
    }

    public void removeNotes(String str) {
        int i = 0;
        while (i < noteList.size()) {
            if (noteList.get(i).getNote().indexOf(str) == -1) {
                i++;
            } else {
                noteList.remove(i);
            }
        }
    }

}
