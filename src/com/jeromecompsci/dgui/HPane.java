package com.jeromecompsci.dgui;

import javax.swing.*;
import java.awt.*;

/**
 * @author Derek Wang
 */
public class HPane extends Pane {
    public HPane(final Widget... widgets) {
        super(widgets);
        executeOnEDT(new Runnable() {
            @Override public void run() {
                SpringUtilities.makeGrid(getInternal(), 1, widgets.length);
            }
        });
    }
}
