package com.jeromecompsci.dgui.examples;

import com.jeromecompsci.dgui.*;

/**
 * @author Derek Wang
 */
public class AdditionProgram {

    private TextField entryA, entryB;
    private Window window;
    private Label resultLabel;
    private Button calculateButton;

    public AdditionProgram() {
        entryA = new TextField();
        entryB = new TextField();
        resultLabel = new Label("");
        calculateButton = new Button(" = ");

        resultLabel.setWidth(100);
        calculateButton.on("click", this, "calculateButtonClicked");

        window = new Window(
                new HCompactPane(new Label("A "), entryA, new Label(" + "), new Label("B "), entryB, calculateButton, resultLabel)
        );
    }

    public void calculateButtonClicked() {
        try {
            int a = Integer.parseInt(entryA.getText());
            int b = Integer.parseInt(entryB.getText());
            int result = a + b;
            resultLabel.setText(" " + Integer.toString(result));
        } catch (NumberFormatException e) {
            resultLabel.setText(" ERR!");
        }
    }

    public static void main(String[] args) {
        AdditionProgram a = new AdditionProgram();
        a.window.show();
    }
}
