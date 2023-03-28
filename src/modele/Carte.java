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
        System.out.println(paquet.get(51));
    }
    private void reculJokerNoir(){
        int indexJokerNoir = paquet.indexOf("joker_noir");
        // on vérifie si le joker noir est à la fin du paquet et on le déplace à la deuxième position
        if (indexJokerNoir == 54){
            Collections.swap(this.paquet, indexJokerNoir, 1);
        }
        else{
            Collections.swap(this.paquet, indexJokerNoir, indexJokerNoir-1);
        }
    }
    private void reculerJokerRouge(){
        //On fait reculer le joker rouge de deux positions
        int indexJokerRouge = paquet.indexOf("joker_rouge");
        if (indexJokerRouge == 53){
            Collections.swap(this.paquet, indexJokerRouge, 2);
        }
        else if (indexJokerRouge == 52){
            Collections.swap(this.paquet, indexJokerRouge, 1);
        }
        else{
            Collections.swap(this.paquet, indexJokerRouge, indexJokerRouge-2);
        }
    }

    public int getNumeroCarte(String carte) {
        return this.cartesNumerosBridgeMap.get(carte);
    }

}
