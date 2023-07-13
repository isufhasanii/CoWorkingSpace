package ch.zli.m223.model;

public class Raum {

    private int raumId;
    private String name;
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
