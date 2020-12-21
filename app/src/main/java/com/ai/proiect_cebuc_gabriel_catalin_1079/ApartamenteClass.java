package com.ai.proiect_cebuc_gabriel_catalin_1079;

public class ApartamenteClass {

    private String titlu;
    private String descriere;
    private int pret;
    private String contant;

    public ApartamenteClass(String titlu, String descriere, int pret, String contant) {
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

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public String getContant() {
        return contant;
    }

    public void setContant(String contant) {
        this.contant = contant;
    }
}
