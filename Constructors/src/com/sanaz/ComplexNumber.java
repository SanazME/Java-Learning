package com.sanaz;

public class ComplexNumber {
    private double real, imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void add(double real, double imaginary){
        this.real += real;
        this.imaginary += imaginary;
    }

    public void add(ComplexNumber num){
        double real = num.getReal();
        double imag = num.getImaginary();

        this.add(real, imag);
    }

    public void subtract(double real, double imaginary){
        this.real -= real;
        this.imaginary -= imaginary;
    }

    public void subtract(ComplexNumber num){
        double real = num.getReal();
        double imag = num.getImaginary();

        this.subtract(real, imag);
    }
}
