package com.casperdaris.beroepsproductgroepc.Objecten;

public class RegioTaal {

    private String taalNaam;
    private Regio regioNaam;

    public RegioTaal(String taalNaam, Regio regioNaam) {
        this.taalNaam = taalNaam;
        this.regioNaam = regioNaam;
    }

    public String getTaalNaam() {
        return taalNaam;
    }

    public void setTaalNaam(String taalNaam) {
        this.taalNaam = taalNaam;
    }

    public Regio getRegioNaam() {
        return regioNaam;
    }

    public void setRegioNaam(Regio regioNaam) {
        this.regioNaam = regioNaam;
    }
}
