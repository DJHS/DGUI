package com.jeromecompsci.dgui;

import javax.swing.*;
import java.awt.*;

/**
 * @author Derek Wang
 */
public class HPane extends Pane {
    public HPane(Widget... widgets) {
        super(widgets);
        SpringUtilities.makeGrid(getInternal(), 1, widgets.length);
    }
}
