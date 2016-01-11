package com.jeromecompsci.dgui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Derek Wang
 */
public class Button extends BindableWidget implements TextBased {
    private JButton button;

    public Button() {
        this("Button");
    }
    public Button(String name) {
        button = new JButton();
        setSize(Widget.DEFAULT_WIDTH, Widget.DEFAULT_HEIGHT);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        setText(name);
    }

    @Override public String getText() {
        return button.getText();
    }

    @Override public void setText(String s) {
        button.setText(s);
    }

    @Override void addBindingAsListener(final Binding binding) {
        button.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent actionEvent) {
                binding.executeBoundMethod();
            }
        });
    }

    @Override public JComponent getInternal() {
        return button;
    }

}
