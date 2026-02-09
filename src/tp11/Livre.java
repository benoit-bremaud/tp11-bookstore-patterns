package tp11;

import tp11.dto.Entity;
import tp11.dto.LivreDTO;

/**
 * Domain entity carrying business data and behavior.
 * It can be converted to a lightweight DTO for transport.
 */
public class Livre implements Entity {
    // Required attributes from the exercise skeleton.
    private int id;
    private String titre;
    private String auteur;
    private double poids ;

    public Livre() {
    }

    public Livre(int id, String titre, String auteur, double poids) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.poids = poids;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public LivreDTO toDTO() {
        return new LivreDTO(id, titre, auteur, poids);
    }
}