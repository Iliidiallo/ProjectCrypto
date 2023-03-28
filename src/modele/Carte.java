package modele;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;


public class Carte {
    private Map<String, Integer> cartesNumerosBridgeMap;
    ArrayList<String> paquet = new ArrayList<>();

    public void initCarteAndMapBridge() {
        // cartes Numeros Bridge Map permet de faire la correspondance entre les cartes et leur numéro selon l'ordre du bridge
        cartesNumerosBridgeMap = new HashMap<String, Integer>();
        String[] signes = {"trefle", "carreau", "coeur", "pique"};
        String[] valeurs = {"as", "2", "3", "4", "5", "6", "7", "8", "9", "10", "valet", "dame", "roi"};
        String carte= "";
        int numero = 1;
        for (String signe : signes) {
            for (String valeur : valeurs) {
                carte = signe + "_" + valeur;
                paquet.add(carte);
                cartesNumerosBridgeMap.put(carte, numero);
                numero++;
            }
        }
        // Ajout des jokers
        cartesNumerosBridgeMap.put("joker_noir", 53);
        paquet.add("joker_noir");
        cartesNumerosBridgeMap.put("joker_rouge", 54);

        paquet.add("joker_rouge");
    }
    public void reculJokerNoir(){
        System.out.println(paquet);
        int indexJokerNoir = paquet.indexOf("joker_noir");
        // on vérifie si le joker noir est à la fin du paquet et on le déplace à la deuxième position
        if (indexJokerNoir == 53){
            Collections.swap(this.paquet, indexJokerNoir, 1);
        }
        else{
            Collections.swap(this.paquet, indexJokerNoir, indexJokerNoir+1);
        }
        System.out.println(paquet);
    }
    public void reculJokerRouge(){
        System.out.println(paquet);
        //On fait reculer le joker rouge de deux positions
        int indexJokerRouge = paquet.indexOf("joker_rouge");
        if (indexJokerRouge == 53){
            Collections.swap(this.paquet, indexJokerRouge, 2);
        }
        else if (indexJokerRouge == 52){
            Collections.swap(this.paquet, indexJokerRouge, 1);
        }
        else{
            Collections.swap(this.paquet, indexJokerRouge, indexJokerRouge+2);
        }
        System.out.println(paquet);
    }

    public void doubleCoupeParRapportAuxJokers(){
        int indexJokerRouge = paquet.indexOf("joker_rouge");
        int indexJokerNoir = paquet.indexOf("joker_noir");
        if (indexJokerRouge<indexJokerNoir){
            ArrayList<String> borneInf = new ArrayList(paquet.subList(0, indexJokerRouge-1));
            ArrayList<String> borneSup = new ArrayList(paquet.subList(indexJokerNoir+1, 53));
            ArrayList<String> borneCent = new ArrayList(paquet.subList(indexJokerRouge,indexJokerNoir));
            // On insert ce qui vient avant le joker rouge dans le paquet
            for (int i = 0; i < borneInf.size(); i++) {
                paquet.set(i, borneInf.get(i));
            }
            // On insert ce qui vient après le joker noir dans le paquet
            for (int i = 0; i < borneCent.size(); i++) {
                paquet.set(i+borneInf.size(), borneCent.get(i));
            }
            for (int i = 0; i < borneSup.size(); i++) {
                paquet.set(i+borneInf.size()+borneCent.size(), borneSup.get(i));
            }

        }
        else{
            ArrayList<String> borneInf = new ArrayList(paquet.subList(0, indexJokerNoir-1));
            ArrayList<String> borneSup = new ArrayList(paquet.subList(indexJokerRouge+1, 53));
            ArrayList<String> borneCent = new ArrayList(paquet.subList(indexJokerNoir,indexJokerRouge));
            // On insert ce qui vient avant le joker noir dans le paquet
            for (int i = 0; i < borneInf.size(); i++) {
                paquet.set(i, borneInf.get(i));
            }
            // On insert ce qui vient après le joker rouge dans le paquet
            for (int i = 0; i < borneCent.size(); i++) {
                paquet.set(i+borneInf.size(), borneCent.get(i));
            }
            for (int i = 0; i < borneSup.size(); i++) {
                paquet.set(i+borneInf.size()+borneCent.size(), borneSup.get(i));
            }
        }

    }

    public int getNumeroCarte(String carte) {
        return this.cartesNumerosBridgeMap.get(carte);
    }

}
