package com.ai.proiect_cebuc_gabriel_catalin_1079;

public class ApartamenteClass {

    private String titlu;
    private String descriere;
    private long pret;
    private String contant;

    public ApartamenteClass(String titlu, String descriere, long pret, String contant) {
        this.titlu = titlu;
        this.descriere = descriere;
        this.pret = pret;
        this.contant = contant;
    }

    public ApartamenteClass() {
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public long getPret() {
        return pret;
    }

    public void setPret(long pret) {
        this.pret = pret;
    }

    public String getContant() {
        return contant;
    }

    public void setContant(String contant) {
        this.contant = contant;
    }

    @Override
    public String toString() {
        return "Titlu: " + titlu + "\n" + "Descriere: " + descriere + "\n" + "Pret: " + pret + "\n" + "Contact: " + contant;

    }

}
