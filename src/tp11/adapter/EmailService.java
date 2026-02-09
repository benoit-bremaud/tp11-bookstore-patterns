package tp11.adapter;

public class EmailService {

    // Interdiction de modifier cette méthode, il s'agit d'un simulacre d'API externe
    public void envoyerEmail(String adresseDestinataire, String sujet, String contenu) {
        // Simuler l'envoi d'un e-mail
        System.out.println("Simulation d'envoi d'email");
        System.out.println("À: " + adresseDestinataire);
        System.out.println("Sujet: " + sujet);
        System.out.println("Contenu: " + contenu);
        System.out.println("Email envoyé avec succès!");
    }
}