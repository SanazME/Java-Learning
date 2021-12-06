package com.sanaz;

public class Printer {
    private int tonerLevel;
    private int pages;
    private boolean isDuplex;

    public Printer(int tonerLevel, boolean isDuplex) {
        if (tonerLevel > -1 && tonerLevel <= 100) {
            this.tonerLevel = tonerLevel;
        } else {
            this.tonerLevel = -1;
        }
        this.isDuplex = isDuplex;
        this.pages = 0;
    }

    public int addToner(int tonerAmount){
        if (tonerAmount > 0 && tonerAmount <= 100){
            if (this.tonerLevel + tonerAmount > 100) {
                return -1;
            } else {
                this.tonerLevel += tonerAmount;
                return this.tonerLevel;
            }
        } else {
            return -1;
        }
    }

    public int printPage(int pages){
        int pagesToPrint = pages;

        if (this.isDuplex){
            // for odd number of pages and Duplex we print on both sides of the page.
            pagesToPrint = pages / 2 + pages % 2;
            System.out.println("Printing in Duplex mode.");
        }
        this.pages += pagesToPrint;
        return pagesToPrint;
    }

    public int getPages() {
        return pages;
    }
}
