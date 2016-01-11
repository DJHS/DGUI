package com.jeromecompsci.dgui.examples;
import com.jeromecompsci.dgui.*;

/**
 * An example akin to BasicGUI (found at https://github.com/DJHS/BasicGUI)
 * This utility class is akin to "YourCode" in the original BasicGUI
 * @author Derek Wang
 */
public class BasicGUIDriver {
    public static BasicGUI gui;

    public static void main(String[] args) {
        gui = new BasicGUI();
        gui.button1.bind(BasicGUIDriver.class, "button1Clicked");
        gui.button2.bind(BasicGUIDriver.class, "button2Clicked");
        /* Write code here to be run at application startup */
    }

    public static void button1Clicked() {
        /* Write code here to be run when the first button is clicked */
        gui.label.setText("Button 1 Clicked!"); // Example
    }

    public static void button2Clicked() {
        /* Write code here to be run when the second button is clicked */
        gui.label.setText("Button 2 Clicked!"); // Example
    }
}

/**
 * This class is akin to "BasicGUI" in the original BasicGUI
 * @author derek
 */
class BasicGUI {
    private Window window;
    Label label = new Label("Label");
    TextField field1 = new TextField();
    TextField field2 = new TextField();
    Button button1 = new Button("Button 1");
    Button button2 = new Button("Button 2");

    public BasicGUI() {
        window = new Window(
            new VPane(
                label,
                new HPane(field1, field2),
                new HPane(button1, button2)
            )
        );
        window.show();
    }
}
