package com.jeromecompsci.dgui;

/**
 * @author Derek Wang
 */
public class HCompactPane extends Pane {
    public HCompactPane(final Widget... widgets) {
        super(widgets);
        executeOnEDT(new Runnable() {
            @Override public void run() {
                SpringUtilities.makeCompactGrid(getInternal(), 1, widgets.length);
            }
        });
    }
}
