package com.jeromecompsci.dgui.examples;
import com.jeromecompsci.dgui.*;

/**
 * @author Derek Wang
 */

public class BreezyGUIComparisonNoComments {
    private Window window;
    private TextField poundsField, ouncesField;
    private Button poundsButton, ouncesButton;

    public BreezyGUIComparisonNoComments() {
        poundsField = new TextField();
        ouncesField = new TextField();
        poundsButton = new Button("To Pounds");
        ouncesButton = new Button("To Ounces");

        poundsButton.bind(this, "poundsButtonClicked");
        ouncesButton.bind(this, "ouncesButtonClicked");

        window = new Window(
            new VPane(
                new HPane(new Label("Pounds"), poundsField),
                new HPane(new Label("Ounces"), ouncesField),
                new HPane(poundsButton, ouncesButton)
            )
        );
    }

    public void poundsButtonClicked() {
        double pounds = Double.parseDouble(poundsField.getText());
        double ounces = 16 * pounds;
        ouncesField.setText(String.format("%.2f", ounces));
    }

    public void ouncesButtonClicked() {
        double ounces = Double.parseDouble(ouncesField.getText());
        double pounds = ounces / 16;
        poundsField.setText(String.format("%.2f", pounds));
    }

    public static void main(String[] args) {
        BreezyGUIComparisonNoComments gui = new BreezyGUIComparisonNoComments();
        gui.window.show();
    }
}
