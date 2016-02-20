package com.jeromecompsci.dgui;

/**
 * @author Derek Wang
 */
public class VCompactPane extends Pane {
    public VCompactPane(final Widget... widgets) {
        super(widgets);
        executeOnEDT(new Runnable() {
            @Override public void run() {
                SpringUtilities.makeCompactGrid(getInternal(), widgets.length, 1);
            }
        });
    }
}
