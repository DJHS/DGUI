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
    public TextField(final String initialText) {
        executeOnEDT(new Runnable() {
            @Override public void run() {
                field = new JTextField();
                field.setText(initialText);
            }
        });
        setSize(Widget.DEFAULT_WIDTH, Widget.DEFAULT_HEIGHT);
    }

    @Override public String getText() {
        return field.getText();
    }

    @Override public void setText(final String s) {
        executeOnEDT(new Runnable() {
            @Override public void run() {
                field.setText(s);
            }
        });
    }

    @Override void addBindingForEvent(String evt, final Binding binding) {
        switch (evt) {
            case "change":
                executeOnEDT(new Runnable() {
                    @Override public void run() {
                        field.addKeyListener(new KeyListener() {
                            @Override
                            public void keyTyped(KeyEvent keyEvent) {
                                binding.executeBoundMethod();
                            }

                            @Override public void keyPressed(KeyEvent keyEvent) { }
                            @Override public void keyReleased(KeyEvent keyEvent) { }
                        });
                    }
                });
                break;
            case "enter":
                executeOnEDT(new Runnable() {
                    @Override public void run() {
                        field.addKeyListener(new KeyListener() {
                            @Override public void keyTyped(KeyEvent keyEvent) { }
                            @Override public void keyPressed(KeyEvent keyEvent) { }

                            @Override public void keyReleased(KeyEvent keyEvent) {
                                if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
                                    binding.executeBoundMethod();
                                }
                            }
                        });
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
