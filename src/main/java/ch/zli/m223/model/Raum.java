package ch.zli.m223.model;

import javax.persistence.*;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
public class Raum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private int raumId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String ausstattung;

    public int getRaumId() {
        return raumId;
    }
    public void setRaumId(int raumId) {
        this.raumId = raumId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAusstattung() {
        return ausstattung;
    }
    public void setAusstattung(String ausstattung) {
        this.ausstattung = ausstattung;
    }
}
