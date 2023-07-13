package ch.zli.m223.model;

import java.util.Date;

public class Buchungsanfrage {

    private int anfrageId;
    private Date datum;
    private String status;
    private Mitglied member;
    private Raum raum;

    public int getAnfrageId() {
        return anfrageId;
    }
    public void setAnfrageId(int anfrageId) {
        this.anfrageId = anfrageId;
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
    public Mitglied getMember() {
        return member;
    }
    public void setMember(Mitglied member) {
        this.member = member;
    }
    public Raum getRaum() {
        return raum;
    }
    public void setRaum(Raum raum) {
        this.raum = raum;
    }

    
    
}
