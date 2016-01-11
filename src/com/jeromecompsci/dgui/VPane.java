package com.jeromecompsci.dgui;

import javax.swing.*;
import java.awt.*;

/**
 * @author Derek Wang
 */
public class VPane extends Pane {
    public VPane(Widget... widgets) {
        super(widgets);
        SpringUtilities.makeGrid(getInternal(), widgets.length, 1);
    }
}
