package com.casperdaris.beroepsproductgroepc.Objecten;

public class RegioReligie {

    private String religieNaam;
    private Regio regioNaam;

    public RegioReligie(String religieNaam, Regio regioNaam) {
        this.religieNaam = religieNaam;
        this.regioNaam = regioNaam;
    }

    public String getReligieNaam() {
        return religieNaam;
    }

    public void setReligieNaam(String religieNaam) {
        this.religieNaam = religieNaam;
    }

    public Regio getRegioNaam() {
        return regioNaam;
    }

    public void setRegioNaam(Regio regioNaam) {
        this.regioNaam = regioNaam;
    }
}
