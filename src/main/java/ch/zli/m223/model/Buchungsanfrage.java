package ch.zli.m223.model;

import java.util.Date;

import javax.persistence.*;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
public class Buchungsanfrage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private int anfrageId;

    @Column(nullable = false)
    private Date datum;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @Column(nullable = false)
    private Mitglied member;

    @ManyToOne
    @Column(nullable = false)
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
