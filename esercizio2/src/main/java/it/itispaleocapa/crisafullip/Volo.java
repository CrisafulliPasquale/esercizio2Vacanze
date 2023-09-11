package it.itispaleocapa.crisafullip;

public class Volo {
    private String codiceVolo;
    private String aeroportoP;
    private String aeroportoA;
    private String dataVolo;
    private String oraP;
    private String oraA;
    private int numeroPosti;
    private double costoVolo;

    public Volo(String codiceVolo, String aeroportoP, String aeroportoA, String dataVolo, String oraP, String oraA, int numeroPosti, double costoVolo) {
        this.codiceVolo = codiceVolo;
        this.aeroportoP = aeroportoP;
        this.aeroportoA = aeroportoA;
        this.dataVolo = dataVolo;
        this.oraP = oraP;
        this.oraA = oraA;
        this.numeroPosti = numeroPosti;
        this.costoVolo = costoVolo;
    }

    public String getCodiceVolo() {
        return codiceVolo;
    }

    public String getaeroportoP() {
        return aeroportoP;
    }

    public String getaeroportoA() {
        return aeroportoA;
    }

    public String getDataVolo() {
        return dataVolo;
    }

    public String getoraP() {
        return oraP;
    }

    public String getoraA() {
        return oraA;
    }

    public int getNumeroPosti() {
        return numeroPosti;
    }

    public double getCostoVolo() {
        return costoVolo;
    }

    public void setaeroportoP(String aeroportoP) {
        this.aeroportoP = aeroportoP;
    }

    public void setaeroportoA(String aeroportoA) {
        this.aeroportoA = aeroportoA;
    }

    public void setDataVolo(String dataVolo) {
        this.dataVolo = dataVolo;
    }

    public void setoraP(String oraP) {
        this.oraP = oraP;
    }

    public void setoraA(String oraA) {
        this.oraA = oraA;
    }

    public void setNumeroPosti(int numeroPosti) {
        this.numeroPosti = numeroPosti;
    }

    public void setCostoVolo(double costoVolo) {
        this.costoVolo = costoVolo;
    }
    
    public void modificaDati(String aeroportoP, String aeroportoA, String dataVolo, String oraP, String oraA, int numeroPosti, double costoVolo) {
        this.aeroportoP = aeroportoP;
        this.aeroportoA = aeroportoA;
        this.dataVolo = dataVolo;
        this.oraP = oraP;
        this.oraA = oraA;
        this.numeroPosti = numeroPosti;
        this.costoVolo = costoVolo;
    }
}
