package com.jeromecompsci.dgui.examples;

import com.jeromecompsci.dgui.*;

/**
 * @author Derek Wang
 */
public class CounterProgram {
    private Window window;
    private Button plus, minus;
    private Label output;
    private int count;

    public CounterProgram() {
        plus = new Button(" + ");
        minus = new Button(" - ");
        output = new Label();

        plus.on("click", this, "plusButtonClicked");
        minus.on("click", this, "minusButtonClicked");

        window = new Window(
                new HPane(
                        output,
                        new VPane(plus, minus)
                )
        );

        window.setText("Counter");

        renderLabel();
    }

    public void plusButtonClicked() {
        this.count++;
        renderLabel();
    }

    public void minusButtonClicked() {
        this.count--;
        renderLabel();
    }

    private void renderLabel() {
        output.setText(Integer.toString(count));
    }

    public static void main(String[] args) {
        CounterProgram t = new CounterProgram();
        t.window.show();
    }
}
