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
        cartesNumerosBridgeMap.put("joker_rouge", 53);
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
        System.out.println("avant coupe");
        System.out.println(paquet);
        int indexJokerRouge = paquet.indexOf("joker_rouge");
        int indexJokerNoir = paquet.indexOf("joker_noir");
        ArrayList<String> borneInf;
        ArrayList<String> borneSup;
        ArrayList<String> borneCent;
        if (indexJokerRouge<indexJokerNoir){
            borneInf = new ArrayList(paquet.subList(0, indexJokerRouge));
            borneSup = indexJokerNoir==53?new ArrayList():new ArrayList(paquet.subList(indexJokerNoir+1, 53));
            borneCent = new ArrayList(paquet.subList(indexJokerRouge,indexJokerNoir+1));
        }
        else{
            borneInf = new ArrayList(paquet.subList(0, indexJokerNoir));
            borneSup = indexJokerRouge==53?new ArrayList():new ArrayList(paquet.subList(indexJokerRouge+1, 53));
            borneCent = new ArrayList(paquet.subList(indexJokerNoir,indexJokerRouge+1));
        }
        for (int i = 0; i < borneSup.size(); i++) {
            paquet.set(i, borneSup.get(i));
        }
        for (int i = 0; i < borneCent.size(); i++) {
            paquet.set(i+borneSup.size(), borneCent.get(i));
        }
        for (int i = 0; i < borneInf.size(); i++) {
            paquet.set(i+borneSup.size()+borneCent.size(), borneInf.get(i));
        }
        System.out.println("après coupe");
        System.out.println(paquet);
    }

    public void coupeSimpleSelonDerniereCarte(){
        System.out.println(paquet);
        int numeroDerniereCarte = cartesNumerosBridgeMap.get(paquet.get(53));
        System.out.println(numeroDerniereCarte);
        ArrayList<String> borneInf = new ArrayList(paquet.subList(0, numeroDerniereCarte));
        ArrayList<String> borneSup = new ArrayList(paquet.subList(numeroDerniereCarte, 53));
        for (int i = 0; i < borneSup.size(); i++) {
            paquet.set(i, borneSup.get(i));
        }
        for (int i = 0; i < borneInf.size(); i++) {
            paquet.set(i+borneSup.size(), borneInf.get(i));
        }
        System.out.println(paquet);
    }


    /*
     public static char lireLettrePseudoAleatoire(List<Integer> paquet, List<Character> clefs) {
    int n = paquet.get(0);
    int index = n;
    if (index > 26) {
        index -= 26;
    }
    while (true) {
        if (paquet.get(index) == 53) { // Joker trouvé
            melangerPaquet(paquet); // Mélanger le paquet
            index = paquet.get(n);
            if (index > 26) {
                index -= 26;
            }
        } else {
            break;
        }
    }
    char lettre = clefs.get(index - 1);
    return lettre;
}

public static void melangerPaquet(List<Integer> paquet) {
    Collections.shuffle(paquet.subList(1, paquet.size()));
}

public static List<Integer> initialiserPaquet() {
    List<Integer> paquet = new ArrayList<>();
    for (int i = 0; i < 54; i++) {
        paquet.add(i);
    }
    return paquet;\n}\n\npublic static List<Character> initialiserClefs() {
    List<Character> clefs = new ArrayList<>();
    for (char c = 'A'; c <= 'Z'; c++) {\n        clefs.add(c);
    }
    return clefs;
}

     */


    public int getNumeroCarte(String carte) {
        return this.cartesNumerosBridgeMap.get(carte);
    }

}