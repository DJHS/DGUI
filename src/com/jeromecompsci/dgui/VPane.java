package com.jeromecompsci.dgui;

import javax.swing.*;
import java.awt.*;

/**
 * @author Derek Wang
 */
public class VPane extends Widget {
    private JPanel panel;
    private SpringLayout layout;

    public VPane(Widget... widgets) {
        panel = new JPanel();
        layout = new SpringLayout();
        panel.setLayout(layout);
        for (Widget w: widgets) {
            panel.add(w.getInternal());
        }
        SpringUtilities.makeGrid(panel, widgets.length, 1);
    }

    @Override public JComponent getInternal() {
        return panel;
    }
}
