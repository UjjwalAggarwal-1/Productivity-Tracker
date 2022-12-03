package core.src;
public class Task {
    String dateAdded;
    String deadlineDate;
    String note;
    String title;

    public Task(String deadlineDate, String note, String title) {
        this.deadlineDate = deadlineDate;
        this.note = note;
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public String getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(String deadlineDate) {
        this.deadlineDate = deadlineDate;
    }
}
