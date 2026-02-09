package tp11.dto;

/**
 * Lightweight data transfer object for Livre.
 * No business logic should be placed here.
 */
public class LivreDTO implements TransferableObject {
    private int id;
    private String titre;
    private String auteur;
    private double poids;

    public LivreDTO() {
    }

    public LivreDTO(int id, String titre, String auteur, double poids) {
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
}