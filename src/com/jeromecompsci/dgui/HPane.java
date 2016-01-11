package com.jeromecompsci.dgui;

import javax.swing.*;
import java.awt.*;

/**
 * @author Derek Wang
 */
public class HPane extends Widget {
    private JPanel panel;
    private SpringLayout layout;

    public HPane(Widget... widgets) {
        panel = new JPanel();
        layout = new SpringLayout();
        panel.setLayout(layout);
        for (Widget w: widgets) {
            panel.add(w.getInternal());
        }
        SpringUtilities.makeGrid(panel, 1, widgets.length);
    }

    @Override public JComponent getInternal() {
        return panel;
    }
}
