package tp11;

import tp11.dto.Entity;
import tp11.dto.UtilisateurDTO;

/**
 * Domain entity carrying business data and behavior.
 * It can be converted to a lightweight DTO for transport.
 */
public class Utilisateur implements Entity {
    // Required attributes from the exercise skeleton.
    private int id;
    private String nom;
    private String email;
    private boolean isPremium = false ;

    public Utilisateur() {
    }

    public Utilisateur(int id, String nom, String email, boolean isPremium) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.isPremium = isPremium;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public UtilisateurDTO toDTO() {
        return new UtilisateurDTO(id, nom, email, isPremium);
    }
}