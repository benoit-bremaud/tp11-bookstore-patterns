package tp11.adapter;

import tp11.dto.CommandeDTO;

public interface NotificationService {
    void envoyerNotification(CommandeDTO commande);
}