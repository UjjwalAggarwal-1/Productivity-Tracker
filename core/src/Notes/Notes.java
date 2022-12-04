package core.src.Notes;

class sinNote
{
    String title ;
    String content;

//    create table notes(title varchar(50), text varchar(200));
    public sinNote (String title, String content)
    {
        this.title = title;
        this.content = content;
    }


}
public class Notes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyNotes o= new MyNotes();
        o.setVisible(true);
    }

}
