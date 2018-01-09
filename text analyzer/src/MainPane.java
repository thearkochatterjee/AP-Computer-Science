import java.awt.*;

public class MainPane extends Container{

    public MainPane(){
        setLayout(new GridLayout(1,2));
        add(new InputPane());
        add(new OutputPane());
    }
}
