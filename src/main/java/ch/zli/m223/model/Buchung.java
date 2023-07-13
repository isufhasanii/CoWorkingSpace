package ch.zli.m223.model;

import java.util.Date;

public class Buchung {

    private int buchungId;
    private Date datum;
    private String status;
    private Mitglied mitglied;
    private Raum raum;

    public int getBuchungId() {
        return buchungId;
    }
    public void setBuchungId(int buchungId) {
        this.buchungId = buchungId;
    }
    public Date getDatum() {
        return datum;
    }
    public void setDatum(Date datum) {
        this.datum = datum;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Mitglied getMitglied() {
        return mitglied;
    }
    public void setMitglied(Mitglied mitglied) {
        this.mitglied = mitglied;
    }
    public Raum getRaum() {
        return raum;
    }
    public void setRaum(Raum raum) {
        this.raum = raum;
    }
    
}
