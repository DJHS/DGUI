package com.jeromecompsci.dgui;

import javax.swing.*;
import java.awt.*;

/**
 * @author Derek Wang
 */
public class Label extends Widget implements TextBased {
    private JLabel label;

    public Label() {
        this("Label");
    }
    public Label(String text) {
        label = new JLabel();
        label.setMaximumSize(new Dimension(Integer.MAX_VALUE, Widget.DEFAULT_HEIGHT));
        setText(text);
    }

    @Override public String getText() {
        return label.getText();
    }

    @Override public void setText(String s) {
        label.setText(s);
    }

    @Override public JComponent getInternal() {
        return label;
    }
}
