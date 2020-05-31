package com.casperdaris.beroepsproductgroepc.Objecten;

public class Stad {

    private String stadNaam, regioNaam;

    public Stad(String stadNaam, String regioNaam) {
        this.stadNaam = stadNaam;
        this.regioNaam=regioNaam;
    }

    public String getRegioNaam() {
        return regioNaam;
    }

    public void setRegioNaam(String regioNaam) {
        this.regioNaam = regioNaam;
    }

    public String getStadNaam() {
        return stadNaam;
    }

    public void setStadNaam(String stadNaam) {
        this.stadNaam = stadNaam;
    }

}
