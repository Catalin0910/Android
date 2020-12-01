package com.ai.proiect_cebuc_gabriel_catalin_1079;

public class Apartemnte {
    private String titlu;
    private String descriereScurta;
    private String descriereLunga;
    private String pret;
    private String dateContact;

    public Apartemnte(String titlu, String descriereScurta, String descriereLunga, String pret, String dateContact) {
        this.titlu = titlu;
        this.descriereScurta = descriereScurta;
        this.descriereLunga = descriereLunga;
        this.pret = pret;
        this.dateContact = dateContact;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getDescriereScurta() {
        return descriereScurta;
    }

    public void setDescriereScurta(String descriereScurta) {
        this.descriereScurta = descriereScurta;
    }

    public String getDescriereLunga() {
        return descriereLunga;
    }

    public void setDescriereLunga(String descriereLunga) {
        this.descriereLunga = descriereLunga;
    }

    public String getPret() {
        return pret;
    }

    public void setPret(String pret) {
        this.pret = pret;
    }

    public String getDateContact() {
        return dateContact;
    }

    public void setDateContact(String dateContact) {
        this.dateContact = dateContact;
    }

    @Override
    public String toString() {
        return "Apartemnte{" +
                "titlu='" + titlu + '\'' +
                ", descriereScurta='" + descriereScurta + '\'' +
                ", descriereLunga='" + descriereLunga + '\'' +
                ", pret='" + pret + '\'' +
                ", dateContact='" + dateContact + '\'' +
                '}';
    }
}
