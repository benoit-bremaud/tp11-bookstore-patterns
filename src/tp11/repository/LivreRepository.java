package tp11.repository;

import tp11.Livre;
import java.util.List;

/************************************************************
 * Pattern Repository :
 * On définit ici notre repository comme un dépôt permettant de réaliser a minima les actions suivantes sur une collection de Livre :
 * - trouver un livre d'après son id
 * - renvoyer l'intégralité de la collection
 * - ajouter un nouveau livre au dépôt
 */
public interface LivreRepository {
    Livre findById(int id);
    List<Livre> findAll();
    void save(Livre livre);
}


