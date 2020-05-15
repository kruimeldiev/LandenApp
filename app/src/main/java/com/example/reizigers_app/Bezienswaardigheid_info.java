package com.example.reizigers_app;

public class Bezienswaardigheid_info {
    public String bezienswaardigheid;
    public String regio;
    public String stad;
    public int betaling;
    public String beschrijving;

    public String getBezienswaardigheid() {
        return bezienswaardigheid;
    }

    public void setBezienswaardigheid(String bezienswaardigheid) {
        this.bezienswaardigheid = bezienswaardigheid;
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

    public int getBetaling() {
        return betaling;
    }

    public void setBetaling(int betaling) {
        this.betaling = betaling;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public Bezienswaardigheid_info(String bezienswaardigheid, String regio, int betaling){
        this.bezienswaardigheid= bezienswaardigheid;
        this.regio= regio;
        this.betaling= betaling;
    }
}

