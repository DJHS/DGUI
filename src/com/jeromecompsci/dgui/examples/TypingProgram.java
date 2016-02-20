package com.jeromecompsci.dgui.examples;

import com.jeromecompsci.dgui.*;

/**
 * @author Derek Wang
 */
public class TypingProgram {
    public static Label label = new Label("");

    public static void main(String[] args) {
        TextField field = new TextField();
        field.on("change", TypingProgram.class, "textChanged");
        field.on("enter", TypingProgram.class, "textSubmitted");

        Window window = new Window(new VPane(field, label));
        window.show();
    }

    public static void textChanged() {
        label.setText("You typed!");
    }

    public static void textSubmitted() {
        label.setText("You pressed RETURN/ENTER!");
    }

}
