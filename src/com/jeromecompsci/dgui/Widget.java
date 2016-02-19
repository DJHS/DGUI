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

    public void setWidth(int width) {
        Dimension s = getInternal().getSize();
        s.width = width;
        getInternal().setSize(s);

        Dimension m = getInternal().getMinimumSize();
        m.width = width;
        getInternal().setMinimumSize(m);

        Dimension p = getInternal().getPreferredSize();
        p.width = width;
        getInternal().setPreferredSize(p);
    }

    public void setHeight(int height) {
        Dimension s = getInternal().getSize();
        s.height = height;
        getInternal().setSize(s);

        Dimension m = getInternal().getMinimumSize();
        m.height = height;
        getInternal().setMinimumSize(m);

        Dimension p = getInternal().getPreferredSize();
        p.height = height;
        getInternal().setPreferredSize(p);
    }
}
