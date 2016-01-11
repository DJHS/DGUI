package com.jeromecompsci.dgui;

import javax.swing.*;

/**
 * @author derek
 */
public class Pane extends Widget {
    private JPanel panel;
    private SpringLayout layout;

    Pane(Widget... widgets) {
        panel = new JPanel();
        layout = new SpringLayout();
        panel.setLayout(layout);
        for (Widget w: widgets) {
            panel.add(w.getInternal());
        }
    }

    @Override public JComponent getInternal() {
        return panel;
    }
}
