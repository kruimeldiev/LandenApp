package com.example.reizigers_app;

public class regio_info {

    private String regio;
    private String hoofdregio;
    private String hoofdstad;
    private Integer populatie;
    private String valuta;
    private String alarmnummer;
    private String beschrijving;
    private String soort;

    public regio_info(String regio, Integer populatie, String valuta, String soort){
        this.regio= regio;
        this.populatie=populatie;
        this.valuta=valuta;
        this.soort= soort;
    }

    public String getRegio() {
        return regio;
    }

    public void setRegio(String regio) {
        this.regio = regio;
    }

    public String getHoofdregio() {
        return hoofdregio;
    }

    public void setHoofdregio(String hoofdregio) {
        this.hoofdregio = hoofdregio;
    }

    public String getHoofdstad() {
        return hoofdstad;
    }

    public void setHoofdstad(String hoofdstad) {
        this.hoofdstad = hoofdstad;
    }

    public Integer getPopulatie() {
        return populatie;
    }

    public void setPopulatie(Integer populatie) {
        this.populatie = populatie;
    }

    public String getValuta() {
        return valuta;
    }

    public void setValuta(String valuta) {
        this.valuta = valuta;
    }

    public String getAlarmnummer() {
        return alarmnummer;
    }

    public void setAlarmnummer(String alarmnummer) {
        this.alarmnummer = alarmnummer;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public String getSoort() {
        return soort;
    }

    public void setSoort(String soort) {
        this.soort = soort;
    }
}
