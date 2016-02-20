package com.jeromecompsci.dgui;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Derek Wang
 */
public class TextField extends BindableWidget implements TextBased {
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

    @Override void addBindingForEvent(String evt, Binding binding) {
        switch (evt) {
            case "change":
                field.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent keyEvent) {
                        binding.executeBoundMethod();
                    }

                    @Override public void keyPressed(KeyEvent keyEvent) { }
                    @Override public void keyReleased(KeyEvent keyEvent) { }
                });
                break;
            case "enter":
                field.addKeyListener(new KeyListener() {
                    @Override public void keyTyped(KeyEvent keyEvent) { }
                    @Override public void keyPressed(KeyEvent keyEvent) { }

                    @Override public void keyReleased(KeyEvent keyEvent) {
                        if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
                            binding.executeBoundMethod();
                        }
                    }
                });
                break;
            default:
                throw BindingException.forNonExistentEvent(evt);
        }
    }

    @Override public JComponent getInternal() {
        return field;
    }

}
