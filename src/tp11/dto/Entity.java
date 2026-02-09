package tp11.dto;

/**
 * Les entités sont les objets complexes contenant de la
 * logique métier que l'on cherche à transformer à DTO
 * pour des raisons de communication. Tout objet de ce genre
 * devra implémenter cette interface et proposer une méthode
 * toDTO() renvoyant la "version DTO" de l'objet.
 */
public interface Entity {

    public TransferableObject toDTO();
}
