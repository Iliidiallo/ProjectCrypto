package CryptoSolitaire;

import modele.Carte;

public class Main {

    public static void main(String[] args) {
        Carte carte = new Carte();
        carte.initCarteAndMapBridge();
        for (int i = 0; i < 20; i++) {
            carte.reculJokerRouge();
        }


        // carte.doubleCoupeParRapportAuxJokers();
       // carte.reculJokerRouge();
        //carte.reculJokerNoir();
        //carte.reculJokerNoir();

        carte.coupeSimpleSelonDerniereCarte();

    }
}
