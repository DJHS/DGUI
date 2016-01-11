package com.jeromecompsci.dgui;

import javax.swing.*;
import java.awt.*;

/**
 * @author Derek Wang
 */
public class Window implements TextBased {
    private JFrame window;
    private SpringLayout layout;

    public Window(Widget mainWidget) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // Do Nothing: we will simply fall back on default LnF
        }

        window = new JFrame();
        layout = new SpringLayout();
        Container c = window.getContentPane();
        c.setLayout(layout);

        window.add(mainWidget.getInternal());
        SpringUtilities.makeGrid(c, 1, 1);

        window.pack();
        window.setMinimumSize(mainWidget.getInternal().getMinimumSize());
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Window");
    }

    public void show() {
        window.setVisible(true);
    }

    public void setResizeable(boolean b) {
        window.setResizable(b);
    }

    @Override public String getText() {
        return window.getTitle();
    }

    @Override public void setText(String s) {
        window.setTitle(s);
    }
}
