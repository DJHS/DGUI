package com.jeromecompsci.dgui;

import javax.swing.*;

/**
 * @author Derek Wang
 */
public class TextField extends Widget implements TextBased {
    private JTextField field;

    public TextField() {
        this("");
    }
    public TextField(String initialText) {
        field = new JTextField();
        setSize(Widget.DEFAULT_WIDTH, Widget.DEFAULT_HEIGHT);
        setText(initialText);
    }

    @Override public String getText() {
        return field.getText();
    }

    @Override public void setText(String s) {
        field.setText(s);
    }

    @Override public JComponent getInternal() {
        return field;
    }
}
