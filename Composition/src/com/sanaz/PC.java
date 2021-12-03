package com.sanaz;

public class PC {
    private Motherboard motherboard;
    private Case TheCase;
    private Monitor monitor;

    public PC(Motherboard motherboard, Case theCase, Monitor monitor) {
        this.motherboard = motherboard;
        TheCase = theCase;
        this.monitor = monitor;
    }

    public void powerUp(){
        TheCase.pressPower();
        drawLogo();
    }

    public void drawLogo(){
        // Fancy graphics
        monitor.drawPixelAt(1200, 50, "yellow");

    }


}
