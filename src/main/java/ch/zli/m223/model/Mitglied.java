package ch.zli.m223.model;

public class Mitglied {

    private int mitgliedId;
    private String vorname;
    private String nachname;
    private String email;
    private String passwort;
    
    public int getMitgliedId() {
        return mitgliedId;
    }
    public void setMitgliedId(int mitgliedId) {
        this.mitgliedId = mitgliedId;
    }
    public String getVorname() {
        return vorname;
    }
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    public String getNachname() {
        return nachname;
    }
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPasswort() {
        return passwort;
    }
    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    

}
