package ch.zli.m223.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private String adminId;

    @Column(nullable = false)
    private String name;

    public String getAdminId() {
        return adminId;
    }
    public String getName() {
        return name;
    }
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
