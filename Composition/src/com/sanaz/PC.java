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

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public Case getTheCase() {
        return TheCase;
    }

    public Monitor getMonitor() {
        return monitor;
    }
}
