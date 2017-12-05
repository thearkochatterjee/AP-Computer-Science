public class Cattime {
    private double time;
    private String catname, subject;

    public Cattime(){
        time = 0.0;
        catname = "";
        subject = "";
    }

    public Cattime(String catname, String subject, double time){
        this.catname = catname;
        this.subject = subject;
        this.time = time;
    }

    public String getSubject() {
        return subject;
    }

    public double getTime() {
        return time;
    }

    public String getCatname() {
        return catname;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }

    public void setTime(double time) {
        this.time = time;
    }
}
