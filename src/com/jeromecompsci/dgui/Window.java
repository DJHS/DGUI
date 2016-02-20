package com.jeromecompsci.dgui;

import javax.swing.*;
import java.awt.*;

/**
 * @author Derek Wang
 */
public class Window implements TextBased {
    private JFrame window;
    private SpringLayout layout;

    public Window(final Widget mainWidget) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // Do Nothing: we will simply fall back on default LnF
        }

        Widget.executeOnEDT(new Runnable() {
            @Override public void run() {
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
        });
    }

    public void show() {
        Widget.executeOnEDT(new Runnable() {
            @Override public void run() {
                window.setVisible(true);
            }
        });
    }

    public void setResizeable(final boolean b) {
        Widget.executeOnEDT(new Runnable() {
            @Override public void run() {
                window.setResizable(b);
            }
        });
    }

    @Override public String getText() {
        return window.getTitle();
    }

    @Override public void setText(final String s) {
        Widget.executeOnEDT(new Runnable() {
            @Override public void run() {
                window.setTitle(s);
            }
        });
    }
}
