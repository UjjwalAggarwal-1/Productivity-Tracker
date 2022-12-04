package core.src.Tasks;

public class task {
    private String title;
    private String description;
    private java.sql.Date deadline;

    task(String title, String description, java.sql.Date deadline) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
    }

    public String getTitle() {
       return title;
    }
    public String getDescription() {
        return description;
    }
    public java.sql.Date getDeadline() {
        return deadline;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setDeadline(java.sql.Date deadline) {
        this.deadline = deadline;
    }
}
