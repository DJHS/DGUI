package com.jeromecompsci.dgui.examples;
import com.jeromecompsci.dgui.*;

/**
 * This class is meant to implement the same UI layout and widgets
 * as the example given by BreezyGUI (using their toolkit)
 * at http://mathbits.com/MathBits/Java/UsingBreezyGUI/ControllingWindow.htm
 * for the sake of comparison. See README.md -> Goals for more details.
 *
 * This file exhibits comments that outline how DGUI embodies our goals,
 * we provide a "NoComments" version if you would prefer to read this
 * example without them.
 *
 * @author Derek Wang
 */

/* See that we did not have to extend the Window class -- we could
 * have if we wanted to, but we chose not to -- a flexibility
 * offered by every major toolkit. */
public class BreezyGUIComparison {

    /* Relying on default initialization is bad practice, so we defer
     * initialization to the constructor (where we also setup bindings).
     * Also, since the labels aren't expected to change, we consider them
     * a part of the layout, which yields cleaner code */
    private Window window;
    private TextField poundsField, ouncesField;
    private Button poundsButton, ouncesButton;

    public BreezyGUIComparison() {
        /* We use plain-old constructors just like every other major
         * toolkit -- not magic factory methods that also perform layout */
        poundsField = new TextField();
        ouncesField = new TextField();
        poundsButton = new Button("To Pounds");
        ouncesButton = new Button("To Ounces");

        /* Our bindings are explicit, not requiring some predefined method.
         * They are reflection-based (b/c Java does not have clean syntactical
         * sugar for callbacks -- but they closely resemble such callbacks found
         * in other toolkits */
        poundsButton.bind(this, "poundsButtonClicked");
        ouncesButton.bind(this, "ouncesButtonClicked");

        /* Our layout: see that it's separate from the Widget-initialization
         * code and observe how the code reveals the structure of the window */
        window = new Window(
            new VPane(
                new HPane(new Label("Pounds"), poundsField),
                new HPane(new Label("Ounces"), ouncesField),
                new HPane(poundsButton, ouncesButton)
            )
        );
    }

    /* See that our binding system avoids the ugly and uncommonly used
     * if-tree and that these method names are up to our discretion */
    public void poundsButtonClicked() {
        /* We defer data handling to the user, as we do not believe number
         * formatting code belongs in core toolkit widgets */
        double ounces = Double.parseDouble(ouncesField.getText());
        double pounds = ounces / 16;
        poundsField.setText(String.format("%.2f", pounds));
    }

    public void ouncesButtonClicked() {
        double pounds = Double.parseDouble(poundsField.getText());
        double ounces = 16 * pounds;
        ouncesField.setText(String.format("%.2f", ounces));
    }

    public static void main(String[] args) {
        BreezyGUIComparison gui = new BreezyGUIComparison();
        gui.window.show();
    }
}
