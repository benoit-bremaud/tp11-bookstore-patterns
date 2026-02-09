package tp11.adapter;

import tp11.dto.CommandeDTO;
import tp11.dto.LivreDTO;

/**
 * Adapter from CommandeDTO to the external email service.
 */
public class EmailNotificationAdapter implements NotificationService {
    private final EmailService emailService;

    public EmailNotificationAdapter(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void envoyerNotification(CommandeDTO commande) {
        String to = commande.getUtilisateur() != null ? commande.getUtilisateur().getEmail() : "";
        String subject = "Notification de commande";

        StringBuilder body = new StringBuilder();
        body.append("Votre commande ")
                .append(commande.getId())
                .append(" vient de passer dans l'état : ")
                .append(commande.getStatus())
                .append("\n")
                .append("Récapitulatif de la commande :")
                .append("\n");

        if (commande.getLivres() != null) {
            for (LivreDTO livre : commande.getLivres()) {
                body.append("• ")
                        .append(livre.getTitre())
                        .append(" de ")
                        .append(livre.getAuteur())
                        .append("\n");
            }
        }

        body.append("Frais de port : ")
                .append(commande.getFraisDePort())
                .append("€");

        emailService.envoyerEmail(to, subject, body.toString());
    }
}