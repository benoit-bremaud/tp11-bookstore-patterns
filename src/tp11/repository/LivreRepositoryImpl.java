package tp11.repository;

import tp11.Livre;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Implémentation simulée du repository (pas de base de données réelle)
 * Dans une application réelle, le repository sera responsable de la
 * persistance et donc de la connexion/gestion de la base de données.
 */
public class LivreRepositoryImpl implements LivreRepository {
    private final Map<Integer, Livre> livres = new LinkedHashMap<>();

    @Override
    public Livre findById(int id) {
        return livres.get(id);
    }

    @Override
    public List<Livre> findAll() {
        return new ArrayList<>(livres.values());
    }

    @Override
    public void save(Livre livre) {
        livres.put(livre.getId(), livre);
    }
}