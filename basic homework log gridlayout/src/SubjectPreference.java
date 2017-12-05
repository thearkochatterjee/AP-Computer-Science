public class SubjectPreference {
    private String name;
    private double grade;

    public SubjectPreference(){
        name = "";
        grade = 0.0;
    }

    public SubjectPreference(String name, double grade){
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String toString() {
        String out = "";
        out = name + "," + grade;
        return out;
    }
}
