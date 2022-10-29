package com.kali.app.Builder;

public class SandwichBuilder {

    String brotArt;
    String aufstrich;
    boolean salat;
    String aufschnitt;
    String käse;

    public SandwichBuilder() {

    }

    public SandwichBuilder setBrotArt(String brotArt) {
        this.brotArt = brotArt;
        return this;
    }

    public SandwichBuilder setAuftstrich(String aufstrich) {
        this.aufstrich = aufstrich;
        return this;
    }

    public SandwichBuilder setSalat(boolean salat) {
        this.salat = salat;
        return this;
    }

    public SandwichBuilder setAufschnitt(String aufschnitt) {
        this.aufschnitt = aufschnitt;
        return this;
    }

    public SandwichBuilder setKäse(String käse) {
        this.käse = käse;
        return this;
    }

    public Sandwich build() {
        return new Sandwich(this);
    }
    
}
