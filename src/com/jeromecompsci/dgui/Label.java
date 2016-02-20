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
    public Label(final String text) {
        executeOnEDT(new Runnable() {
            @Override public void run() {
                label = new JLabel();
                label.setMaximumSize(new Dimension(Integer.MAX_VALUE, Widget.DEFAULT_HEIGHT));
                label.setText(text);
            }
        });
    }

    @Override public String getText() {
        return label.getText();
    }

    @Override public void setText(final String s) {
        executeOnEDT(new Runnable() {
            @Override public void run() {
                label.setText(s);
            }
        });
    }

    @Override public JComponent getInternal() {
        return label;
    }
}
