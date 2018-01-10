import java.awt.*;

public class MainPane extends Container{
    private InputPane panein = new InputPane();
    private OutputPane paneout = new OutputPane();

    public MainPane(){
        setLayout(new GridLayout(1,2));
        add(panein);
        add(paneout);
    }

    public InputPane getPanein() {
        return panein;
    }

    public OutputPane getPaneout() {
        return paneout;
    }
}
