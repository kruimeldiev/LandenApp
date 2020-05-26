package com.casperdaris.beroepsproductgroepc.Objecten;

public class RegioSport {

    private String sportNaam;
    private Regio regioNaam;

    public RegioSport(String sportNaam, Regio regioNaam) {
        this.sportNaam = sportNaam;
        this.regioNaam = regioNaam;
    }

    public String getSportNaam() {
        return sportNaam;
    }

    public void setSportNaam(String sportNaam) {
        this.sportNaam = sportNaam;
    }

    public Regio getRegioNaam() {
        return regioNaam;
    }

    public void setRegioNaam(Regio regioNaam) {
        this.regioNaam = regioNaam;
    }
}
