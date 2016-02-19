package com.jeromecompsci.dgui;

/**
 * @author Derek Wang
 */
public class VCompactPane extends Pane {
    public VCompactPane(Widget... widgets) {
        super(widgets);
        SpringUtilities.makeCompactGrid(getInternal(), widgets.length, 1);
    }
}
