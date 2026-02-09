package tp11.dto;
import java.util.List;


/********************************************************
 * Les DTO sont des objets simplifiés représentant l'état
 * (les attributs) d'un objet complexe, dont on a retiré
 * toute logique métier. De ce fait, les DTO deviennent
 * des objets plus faciles à sérializer et plus légers
 **********************************************************/
public class CommandeDTO implements TransferableObject{
    private List<LivreDTO> livres;
    private UtilisateurDTO utilisateur ;
    // A vous de définir les attributs, le constructeur et les getters/setters
    // Pour vous aider, je vous ai laissé 2 attributs utilisant les autres DTO. A vous de faire le reste
    // n'oubliez pas : aucune logique métier ici !!
}