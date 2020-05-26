package com.casperdaris.beroepsproductgroepc.Objecten;

public class Valuta {

    private String valutaNaam;
    private Character valutaTeken;

    public Valuta(String valutaNaam, Character valutaTeken) {
        this.valutaNaam = valutaNaam;
        this.valutaTeken = valutaTeken;
    }

    public void setValutaNaam(String valutaNaam) {
        this.valutaNaam = valutaNaam;
    }

    public String getValutaNaam() {
        return valutaNaam;
    }

    public void setValutaTeken(Character valutaTeken) {
        this.valutaTeken = valutaTeken;
    }

    public Character getValutaTeken() {
        return valutaTeken;
    }
}
