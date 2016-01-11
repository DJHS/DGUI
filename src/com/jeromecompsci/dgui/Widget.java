package com.jeromecompsci.dgui;

import javax.swing.*;
import java.awt.*;

/**
 * @author Derek Wang
 */
public abstract class Widget {
    static int PADDING = 2;
    static int DEFAULT_WIDTH = 150;
    static int DEFAULT_HEIGHT = 25;
    abstract JComponent getInternal();
    public void setSize(int width, int height) {
        Dimension d = new Dimension(width, height);
        getInternal().setSize(d);
        getInternal().setMinimumSize(d);
        getInternal().setPreferredSize(d);
    }
}
