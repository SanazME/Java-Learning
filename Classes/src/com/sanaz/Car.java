package com.sanaz;

import java.util.Locale;

public class Car {
    private int doors;
    private int wheels;
    private String model;
    private String engine;
    private String color;

    public void setModel(String model) {
        String validModel = model.toLowerCase();
        // add check and conditoin that set the model only if the model value is equal to one of the followings otherwise it'll set the model to unknown.
        if (validModel.equals("carrera") || validModel.equals("commodore")){
            this.model = model;
        } else {
            this.model = "Unknown";
        }
    }

    public String getModel() {
        return model;
    }
}


