package tp11;

import tp11.adapter.EmailNotificationAdapter;
import tp11.adapter.EmailService;
import tp11.adapter.NotificationService;
import tp11.repository.LivreRepository;
import tp11.repository.LivreRepositoryImpl;
import tp11.strategy.FraisPortColissimoStrategy;
import tp11.strategy.FraisPortMondialRelayStrategy;

public class Main {

    public static void main(String[] args) {

        /********************************************************************************************************
        Dans ce code, chaque section teste un pattern spécifique :
            Repository Pattern: Teste l'ajout et la récupération des livres via LivreRepository.
            Lazy Loading: Charge les détails de la commande uniquement lorsque nécessaire.
            Strategy Pattern: Calcule les frais de port en utilisant une stratégie spécifique.
            State Pattern: Change l'état d'une commande et vérifie le nouvel état.
            Adapter Pattern: Intègre un service de notification externe (ici représenté par EmailService).

         Vous ne devez pas modifier ce fichier pour réaliser le TP (sauf pour commenter/décommenter des parties pour tester)
         *********************************************************************************************************/

        /************ INITIALISATION */
        // Création et injection des dépendances
        LivreRepository livreRepository = new LivreRepositoryImpl(); // on crée le repository

        // Création de quelques livres pour tester
        // livre n°1
        Livre livre1 = new Livre();
        livre1.setId(1);
        livre1.setTitre("Le Comte de Monte-Cristo");
        livre1.setAuteur("Alexandre Dumas");
        livre1.setPoids(0.450);

        // livre n°2
        Livre livre2 = new Livre();
        livre2.setId(2);
        livre2.setTitre("1984");
        livre2.setAuteur("George Orwell");
        livre2.setPoids(0.340);

        // livre n°3
        Livre livre3 = new Livre();
        livre3.setId(3);
        livre3.setTitre("Les trois mousquetaires");
        livre3.setAuteur("Alexandre Dumas");
        livre3.setPoids(0.670);

        // Test du Repository Pattern
        System.out.println("******************************************************************************");
        System.out.println("Test Repository Pattern :");
        // Sauvegarde des livres dans le repository
        livreRepository.save(livre1);
        System.out.println("Enregistrement du livre : "+livre1.getTitre());
        livreRepository.save(livre2);
        System.out.println("Enregistrement du livre : "+livre2.getTitre());
        livreRepository.save(livre3);
        System.out.println("Enregistrement du livre : "+livre3.getTitre());
        System.out.println("Livres enregistrés :");
        livreRepository.findAll().forEach(livre -> System.out.println("• "+livre.getTitre()));
        // Affichage attendu :
        //• Le Comte de Monte-Cristo
        //• 1984
        //• Les trois mousquetaires

        // Test du Pattern Lazy Loading
        System.out.println("******************************************************************************");
        System.out.println("\nTest Lazy Loading :");
        // Création d'une commande classique
        Commande commande = new Commande();
        commande.setId(47123);
        Utilisateur client = new Utilisateur();
        client.setNom("John Doe");
        client.setId(42);
        client.setEmail("johndoe@fakemail.com");
        commande.setUtilisateur(client);
        // on ajoute deux livres à la commande par leur id uniquement
        commande.addLivreId(1);
        commande.addLivreId(3);
        System.out.println("Détails de la commande chargés à la demande :");
        commande.getLivres(livreRepository).forEach(livre -> System.out.println("• "+livre.getTitre()));
        // Affichage attendu :
        //• Le Comte de Monte-Cristo
        //• Les trois mousquetaires

        // Test du Pattern Strategy pour les frais de port
        System.out.println("******************************************************************************");
        System.out.println("\nTest Strategy Pattern pour les frais de port (Colissimo) :");
        double frais = commande.calculerFraisDePort(new FraisPortColissimoStrategy(commande));
        System.out.println("Frais de port calculés: " + frais+"€");
        // Affichage attendu : Frais de port calculés: 5.0€
        System.out.println("\nTest Strategy Pattern pour les frais de port (Mondial Relay) :");
        frais = commande.calculerFraisDePort(new FraisPortMondialRelayStrategy(commande));
        System.out.println("Frais de port calculés: " + frais+"€");
        // Affichage attendu : Frais de port calculés: 4.0€

        // Test du Pattern State pour le suivi des commandes
        System.out.println("******************************************************************************");
        System.out.println("\nTest State Pattern :");
        System.out.println("État de la commande au début : " + commande.getStatus());
        // Affichage attendu : État de la commande au début : Commande créée
        commande.etatSuivant();
        System.out.println("État de la commande après passage à l'état suivant : " + commande.getStatus());
        // Affichage attendu : État de la commande après passage à l'état suivant : Expédiée
        commande.etatSuivant();
        System.out.println("État de la commande après passage à l'état suivant : " + commande.getStatus());
        // Affichage attendu : État de la commande après passage à l'état suivant : Livrée

        // Test du Pattern Adapter
        // Dans la pratique, EmailService est une bibliothèque externe que vous voulez adapter,
        // dans notre exemple EmailService sera juste une simulation de ce service
        // qui aura besoin d'objets DTO pour fonctionner
        System.out.println("******************************************************************************");
        System.out.println("\nTest Adapter Pattern pour les notifications (avec DTO) :");
        NotificationService notificationService = new EmailNotificationAdapter(new EmailService());
        notificationService.envoyerNotification(commande.toDTO());
        // Affichage attendu :
        //Simulation d'envoi d'email
        //À: johndoe@fakemail.com
        //Sujet: Notification de commande
        //Contenu: Votre commande 47123 vient de passer dans l'état : Livrée
        //Récapitulatif de la commande :
        //• Le Comte de Monte-Cristo de Alexandre Dumas
        //• Les trois mousquetaires de Alexandre Dumas
        //Frais de port : 4.0€
        //Email envoyé avec succès!

        // Vérification finale
        System.out.println("******************************************************************************");
        System.out.println("\nTests terminés. Vérifiez la sortie pour confirmer le fonctionnement correct des patterns.");
    }
}
