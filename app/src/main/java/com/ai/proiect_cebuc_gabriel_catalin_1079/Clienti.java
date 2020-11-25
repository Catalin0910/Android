package com.ai.proiect_cebuc_gabriel_catalin_1079;

import android.os.Parcel;
import android.os.Parcelable;

public class Clienti implements Parcelable {

    private String prenume;
    private String nume;
    private String email;
    private String parola;
    private String reparola;
    private String tip;
    private boolean consent;
    private boolean emailAgrement;

    public Clienti(){}

    protected Clienti(Parcel in) {
        prenume = in.readString();
        nume = in.readString();
        email = in.readString();
        parola = in.readString();
        reparola = in.readString();
        tip = in.readString();
        consent = in.readByte() != 0;
        emailAgrement = in.readByte() != 0;
    }

    public static final Creator<Clienti> CREATOR = new Creator<Clienti>() {
        @Override
        public Clienti createFromParcel(Parcel in) {
            return new Clienti(in);
        }

        @Override
        public Clienti[] newArray(int size) {
            return new Clienti[size];
        }
    };

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getReparola() {
        return reparola;
    }

    public void setReparola(String reparola) {
        this.reparola = reparola;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public boolean isConsent() {
        return consent;
    }

    public void setConsent(boolean consent) {
        this.consent = consent;
    }

    public boolean isEmailAgrement() {
        return emailAgrement;
    }

    public void setEmailAgrement(boolean emailAgrement) {
        this.emailAgrement = emailAgrement;
    }

    @Override
    public String toString() {
        return "Clienti{" +
                "prenume='" + prenume + '\'' +
                ", nume='" + nume + '\'' +
                ", email='" + email + '\'' +
                ", parola='" + parola + '\'' +
                ", reparola='" + reparola + '\'' +
                ", tip='" + tip + '\'' +
                ", consent=" + consent +
                ", emailAgrement=" + emailAgrement +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(prenume);
        dest.writeString(nume);
        dest.writeString(email);
        dest.writeString(parola);
        dest.writeString(reparola);
        dest.writeString(tip);
        dest.writeByte((byte) (consent ? 1 : 0));
        dest.writeByte((byte) (emailAgrement ? 1 : 0));
    }
}
