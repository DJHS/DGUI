package com.jeromecompsci.dgui;

/**
 * @author Derek Wang
 */
public class VPane extends Pane {
    public VPane(final Widget... widgets) {
        super(widgets);
        executeOnEDT(new Runnable() {
            @Override public void run() {
                SpringUtilities.makeGrid(getInternal(), widgets.length, 1);
            }
        });
    }
}
