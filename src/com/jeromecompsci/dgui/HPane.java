package com.jeromecompsci.dgui;

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
