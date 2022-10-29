package com.kali.app.Builder;

public class Sandwich {

    String brotArt;
    String aufstrich;
    boolean salat;
    String aufschnitt;
    String käse;

    public Sandwich(SandwichBuilder sandwichBuilder) {
        this.brotArt = sandwichBuilder.brotArt;
        this.aufstrich = sandwichBuilder.aufstrich;
        this.salat = sandwichBuilder.salat;
        this.aufschnitt = sandwichBuilder.aufschnitt;
        this.käse = sandwichBuilder.käse;
    }

    public String getBrotArt() {
        return brotArt;
    }
    public void setBrotArt(String brotArt) {
        this.brotArt = brotArt;
    }
    public String getAufstrich() {
        return aufstrich;
    }
    public void setAufstrich(String aufstrich) {
        this.aufstrich = aufstrich;
    }
    public boolean getSalat() {
        return salat;
    }
    public void setSalat(boolean salat) {
        this.salat = salat;
    }
    public String getAufschnitt() {
        return aufschnitt;
    }
    public void setAufschnitt(String aufschnitt) {
        this.aufschnitt = aufschnitt;
    }
    public String getKäse() {
        return käse;
    }
    public void setKäse(String käse) {
        this.käse = käse;
    }

    
    
}
