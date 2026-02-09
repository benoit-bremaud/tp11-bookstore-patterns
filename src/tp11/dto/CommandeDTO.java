package tp11.dto;

import java.util.List;

/**
 * Lightweight data transfer object for Commande.
 * No business logic should be placed here.
 */
public class CommandeDTO implements TransferableObject {
    private int id;
    private List<LivreDTO> livres;
    private UtilisateurDTO utilisateur;
    private String status;
    private double fraisDePort;

    public CommandeDTO() {
    }

    public CommandeDTO(int id, List<LivreDTO> livres, UtilisateurDTO utilisateur, String status, double fraisDePort) {
        this.id = id;
        this.livres = livres;
        this.utilisateur = utilisateur;
        this.status = status;
        this.fraisDePort = fraisDePort;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<LivreDTO> getLivres() {
        return livres;
    }

    public void setLivres(List<LivreDTO> livres) {
        this.livres = livres;
    }

    public UtilisateurDTO getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateurDTO utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getFraisDePort() {
        return fraisDePort;
    }

    public void setFraisDePort(double fraisDePort) {
        this.fraisDePort = fraisDePort;
    }
}