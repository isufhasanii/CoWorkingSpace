package ch.zli.m223.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

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
    @Column(nullable = false)
    private Mitglied mitglied;

    @ManyToOne
    @Column(nullable = false)
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
