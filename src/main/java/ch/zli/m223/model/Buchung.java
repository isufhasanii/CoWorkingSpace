package ch.zli.m223.model;

import java.util.Date;

import javax.persistence.*;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
public class Buchung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private int buchungId;
    
    @Column(nullable = false)
    private Date datum;

    @Column(nullable = false)
    private int zeitraum;

    @ManyToOne
    private Mitglied member;

    @ManyToOne
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
    public int getZeitraum() {
        return zeitraum;
    }
    public void setZeitraum(int zeitraum) {
        this.zeitraum = zeitraum;
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