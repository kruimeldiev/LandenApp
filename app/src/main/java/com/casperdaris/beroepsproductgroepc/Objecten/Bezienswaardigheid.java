package com.casperdaris.beroepsproductgroepc.Objecten;

public class Bezienswaardigheid {

    private String bezienswaardigheidNaam, beschrijving, regio, stad, betaling;

    public Bezienswaardigheid(String bezienswaardigheidNaam, String beschrijving, String regioNaam, String stadNaam, String betaling) {
        this.bezienswaardigheidNaam = bezienswaardigheidNaam;
        this.beschrijving = beschrijving;
        this.regio = regioNaam;
        this.stad = stadNaam;
        this.betaling = betaling;
    }

    public String getBezienswaardigheidNaam() {
        return bezienswaardigheidNaam;
    }

    public void setBezienswaardigheidNaam(String bezienswaardigheidNaam) {
        this.bezienswaardigheidNaam = bezienswaardigheidNaam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public String getRegio() {
        return regio;
    }

    public void setRegio(String regio) {
        this.regio = regio;
    }

    public String getStad() {
        return stad;
    }

    public void setStad(String stad) {
        this.stad = stad;
    }

    public String getBetaling() {
        return betaling;
    }

    public void setBetaling(String betaling) {
        this.betaling = betaling;
    }
}
