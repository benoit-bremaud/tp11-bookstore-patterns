package tp11.dto;

/**
 * Lightweight data transfer object for Utilisateur.
 * No business logic should be placed here.
 */
public class UtilisateurDTO implements TransferableObject {
    private int id;
    private String nom;
    private String email;
    private boolean isPremium;

    public UtilisateurDTO() {
    }

    public UtilisateurDTO(int id, String nom, String email, boolean isPremium) {
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
}