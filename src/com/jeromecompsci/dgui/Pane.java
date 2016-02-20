package com.jeromecompsci.dgui;

import javax.swing.*;

/**
 * @author derek
 */
class Pane extends Widget {
    private JPanel panel;
    private SpringLayout layout;

    Pane(final Widget... widgets) {
        executeOnEDT(new Runnable() {
            @Override public void run() {
                panel = new JPanel();
                layout = new SpringLayout();
                panel.setLayout(layout);
                for (Widget w: widgets) {
                    panel.add(w.getInternal());
                }
            }
        });
    }

    @Override public JComponent getInternal() {
        return panel;
    }
}
