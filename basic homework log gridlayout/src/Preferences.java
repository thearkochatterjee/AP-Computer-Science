import java.util.ArrayList;

public class Preferences {
    private String name;
    private ArrayList<SubjectPreference> arrsubpref = new ArrayList<SubjectPreference>();
    private ArrayList<Cattime> arrcattime = new ArrayList<Cattime>();

    public Preferences(){
        name = "";
        arrsubpref = new ArrayList<SubjectPreference>();
        arrcattime = new ArrayList<Cattime>();
    }

    public Preferences(String name, ArrayList<SubjectPreference> arrsubpref, ArrayList<Cattime> arrcattime){
        this.name = name;
        this.arrcattime = arrcattime;
        this.arrsubpref = arrsubpref;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Cattime> getArrcattime() {
        return arrcattime;
    }

    public ArrayList<SubjectPreference> getArrsubpref() {
        return arrsubpref;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArrcattime(ArrayList<Cattime> arrcattime) {
        this.arrcattime = arrcattime;
    }

    public void setArrsubpref(ArrayList<SubjectPreference> arrsubpref) {
        this.arrsubpref = arrsubpref;
    }
}
