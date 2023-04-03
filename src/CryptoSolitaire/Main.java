package CryptoSolitaire;

import modele.Carte;
import modele.FluxDeClefs;

public class Main {

    public static void main(String[] args) {
        Carte carte = new Carte();
        carte.initCarteAndMapBridge();
     //   for (int i = 0; i < 20; i++) {
        //carte.reculJokerRouge();
       // }


        // carte.doubleCoupeParRapportAuxJokers();

        //carte.reculJokerRouge();
       //carte.reculJokerNoir();
       // carte.reculJokerNoir();

        //carte.coupeSimpleSelonDerniereCarte();

      // carte.lectureLettrePseudoAleatoire();

        FluxDeClefs fluxDeClefs = new FluxDeClefs();
        String message = "SALAM &/";
        String messageCrypte = fluxDeClefs.crypterMessage(message,carte);


        String messageDecrypte = fluxDeClefs.decrypterMessage(messageCrypte);

        System.out.println("Le message crypté est "+messageCrypte);

        System.out.println("Le message decrypté est "+messageDecrypte);

    }
}

