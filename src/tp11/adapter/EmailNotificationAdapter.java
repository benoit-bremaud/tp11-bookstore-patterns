package tp11.adapter;

import tp11.dto.CommandeDTO;
import tp11.dto.LivreDTO;

/*****************************************************************************
 * Ici on souhaite adapter notre Commande, et plus particulièrement la
 * version DTO (légère) de notre Commande afin d'utiliser un service externe qui
 * ne connait pas nos objets.
 * Ce service externe (ici représenté par EmailService, une classe simulant l'envoi d'un email)
 * ne peut pas prendre en paramètre un objet DTO et ne peut fonctionner qu'avec des String
 * (voyez celà comme une API). A vous d'écrire un adaptateur permettant de passer d'un
 * CommandeDTO au service. Regardez le Main pour bien comprendre ce que vous devez envoyer exactement comme
 * textes au service d'emails.
 */
public class EmailNotificationAdapter implements NotificationService {
    private EmailService emailService;

    public EmailNotificationAdapter(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void envoyerNotification(CommandeDTO commande) {
        // A vous de coder cette méthode pour obtenir très exactement le résultat attendu dans le Main
        // tout en utilisant emailService.
        // Bien sûr, si la commande change, le résultat doit s'adapter.
    }
}
