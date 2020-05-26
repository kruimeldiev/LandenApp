package com.casperdaris.beroepsproductgroepc.Objecten;

public class RegioSpecialiteit {

    private String specialiteitNaam, specialiteitSoort;
    private Regio regioNaam;

    public RegioSpecialiteit(String specialiteitNaam, String specialiteitSoort, Regio regioNaam) {
        this.specialiteitNaam = specialiteitNaam;
        this.specialiteitSoort = specialiteitSoort;
        this.regioNaam = regioNaam;
    }

    public String getSpecialiteitNaam() {
        return specialiteitNaam;
    }

    public void setSpecialiteitNaam(String specialiteitNaam) {
        this.specialiteitNaam = specialiteitNaam;
    }

    public String getSpecialiteitSoort() {
        return specialiteitSoort;
    }

    public void setSpecialiteitSoort(String specialiteitSoort) {
        this.specialiteitSoort = specialiteitSoort;
    }

    public Regio getRegioNaam() {
        return regioNaam;
    }

    public void setRegioNaam(Regio regioNaam) {
        this.regioNaam = regioNaam;
    }
}
