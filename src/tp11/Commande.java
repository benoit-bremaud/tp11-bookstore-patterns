package tp11;

import tp11.dto.CommandeDTO;
import tp11.dto.Entity;
import tp11.dto.LivreDTO;
import tp11.repository.LivreRepository;
import tp11.state.CommandeEnCours;
import tp11.state.CommandeState;
import tp11.strategy.FraisPortStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Domain entity carrying business logic for an order.
 * It also supports conversion to a lightweight DTO.
 */
public class Commande implements Entity {
    // Required attributes from the exercise skeleton.
    private int id;
    private Utilisateur utilisateur;
    private String status;
    private CommandeState currentState = null ; // current order state
    private double fraisDePort ;

    // Lazy-loading fields
    private List<Integer> livreIds = new ArrayList<>();
    private transient List<Livre> livres; // Loaded on demand

    public Commande() {
        this.status = "Commande créée";
        this.currentState = new CommandeEnCours();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CommandeState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(CommandeState currentState) {
        this.currentState = currentState;
    }

    public double getFraisDePort() {
        return fraisDePort;
    }

    public void setFraisDePort(double fraisDePort) {
        this.fraisDePort = fraisDePort;
    }

    public List<Integer> getLivreIds() {
        return livreIds;
    }

    public void setLivreIds(List<Integer> livreIds) {
        this.livreIds = livreIds;
        this.livres = null;
    }

    /**
     * Adds only book ids first, then resolves real book objects on first getLivres(...) call.
     * Subsequent calls reuse the cached loaded list.
     */
    public void addLivreId(int livreId) {
        this.livreIds.add(livreId);
        this.livres = null;
    }

    public List<Livre> getLivres(LivreRepository repo) {
        if (livres == null) {
            livres = livreIds.stream()
                    .map(repo::findById)
                    .filter(livre -> livre != null)
                    .collect(Collectors.toList());
        }
        return livres;
    }

    /**
     * Returns the currently loaded books snapshot.
     * This does not trigger repository loading.
     */
    public List<Livre> getLoadedLivres() {
        return livres != null ? new ArrayList<>(livres) : new ArrayList<>();
    }

    public boolean hasLivreIds() {
        return livreIds != null && !livreIds.isEmpty();
    }
    // End lazy loading


    // Strategy pattern
    public double calculerFraisDePort(FraisPortStrategy strategy)
    {
        this.fraisDePort = strategy.calculerFraisPort();
        return this.fraisDePort;
    }

    // State pattern
    public void etatSuivant()
    {
        if (currentState != null) {
            currentState.next(this);
        }
    }

    @Override
    public CommandeDTO toDTO() {
        List<LivreDTO> livreDTOs = new ArrayList<>();
        if (livres != null) {
            livreDTOs = livres.stream()
                    .map(Livre::toDTO)
                    .collect(Collectors.toList());
        }

        return new CommandeDTO(
                id,
                livreDTOs,
                utilisateur != null ? utilisateur.toDTO() : null,
                status,
                fraisDePort
        );
    }
}