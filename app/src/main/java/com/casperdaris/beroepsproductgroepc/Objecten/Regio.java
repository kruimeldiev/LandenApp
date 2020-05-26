package com.casperdaris.beroepsproductgroepc.Objecten;

public class Regio {

    private String regioNaam, beschrijving, hoofdRegio, hoofdStad, regioValuta, regioSoort, alarmNummer;
    private Integer populatie;

    public Regio(String regioNaam, String beschrijving, String hoofdRegio, String hoofdStad, Integer populatie, String regioValuta, String regioSoort, String alarmNummer) {
        this.regioNaam = regioNaam;
        this.beschrijving = beschrijving;
        this.hoofdRegio = hoofdRegio;
        this.hoofdStad = hoofdStad;
        this.populatie = populatie;
        this.regioValuta = regioValuta;
        this.regioSoort = regioSoort;
        this.alarmNummer = alarmNummer;
    }

    public String getRegioNaam() {
        return regioNaam;
    }

    public void setRegioNaam(String regioNaam) {
        this.regioNaam = regioNaam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public String getHoofdRegio() {
        return hoofdRegio;
    }

    public void setHoofdRegio(String hoofdRegio) {
        this.hoofdRegio = hoofdRegio;
    }

    public String getHoofdStad() {
        return hoofdStad;
    }

    public void setHoofdStad(String hoofdStad) {
        this.hoofdStad = hoofdStad;
    }

    public String getRegioValuta() {
        return regioValuta;
    }

    public void setRegioValuta(String regioValuta) {
        this.regioValuta = regioValuta;
    }

    public String getRegioSoort() {
        return regioSoort;
    }

    public void setRegioSoort(String regioSoort) {
        this.regioSoort = regioSoort;
    }

    public String getAlarmNummer() {
        return alarmNummer;
    }

    public void setAlarmNummer(String alarmNummer) {
        this.alarmNummer = alarmNummer;
    }

    public Integer getPopulatie() {
        return populatie;
    }

    public void setPopulatie(Integer populatie) {
        this.populatie = populatie;
    }
}
