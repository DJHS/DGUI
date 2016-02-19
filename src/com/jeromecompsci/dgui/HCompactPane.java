package com.jeromecompsci.dgui;

/**
 * @author Derek Wang
 */
public class HCompactPane extends Pane {
    public HCompactPane(Widget... widgets) {
        super(widgets);
        SpringUtilities.makeCompactGrid(getInternal(), 1, widgets.length);
    }
}
