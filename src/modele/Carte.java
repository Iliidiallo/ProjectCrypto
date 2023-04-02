package modele;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;


public class Carte {
    private Map<String, Integer> cartesNumerosBridgeMap;
    ArrayList<String> paquet = new ArrayList<>();

    public void initCarteAndMapBridge() {
        //Cartes Numeros Bridge Map permet de faire la correspondance entre les cartes et leur numéro selon l'ordre du bridge
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
        //System.out.println(cartesNumerosBridgeMap);
       // System.out.println(paquet);
    }
    public void reculJokerNoir(){
        System.out.println("recul joker noir");
       // System.out.println(paquet);
        int indexJokerNoir = paquet.indexOf("joker_noir");
        System.out.println(indexJokerNoir);
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
        System.out.println("recul joker rouge");
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
       // System.out.println(paquet);
    }

    public void doubleCoupeParRapportAuxJokers(){
        System.out.println("avant coupe double");
       // System.out.println(paquet);
        int indexJokerRouge = paquet.indexOf("joker_rouge");
        int indexJokerNoir = paquet.indexOf("joker_noir");

        System.out.println("indexJokerRouge : "+indexJokerRouge);
        System.out.println("indexJokerNoir : "+indexJokerNoir);
        ArrayList<String> borneInf;
        ArrayList<String> borneSup;
        ArrayList<String> borneCent;
        if (indexJokerRouge < indexJokerNoir){
            borneInf = new ArrayList(paquet.subList(0, indexJokerRouge));
            borneSup = indexJokerNoir==53?new ArrayList():new ArrayList(paquet.subList(indexJokerNoir+1, 54));
            borneCent = new ArrayList(paquet.subList(indexJokerRouge,indexJokerNoir+1));
        }
        else{
            borneInf = new ArrayList(paquet.subList(0, indexJokerNoir));
            borneSup = indexJokerRouge==53?new ArrayList():new ArrayList(paquet.subList(indexJokerRouge+1, 54));
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
        System.out.println("après coupe double");
        //System.out.println(paquet);
    }

    public void coupeSimpleSelonDerniereCarte(){
        System.out.println("simple coupe");
       // System.out.println(paquet);
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
       // System.out.println(paquet);
    }
    public int lectureLettrePseudoAleatoire() {

        System.out.println("Lecture lettre pseudo aléatoire");
        System.out.println(paquet);
        int numeroPremiereCarte = cartesNumerosBridgeMap.get(paquet.get(2));
        System.out.println(numeroPremiereCarte);
        int numeroCarte = cartesNumerosBridgeMap.get(paquet.get(numeroPremiereCarte));
        // System.out.println(cartesNumerosBridgeMap);
        System.out.println(numeroCarte);
        if (numeroCarte == 53) {
            this.reculJokerNoir();
            this.reculJokerRouge();
            this.doubleCoupeParRapportAuxJokers();
            this.coupeSimpleSelonDerniereCarte();
            return lectureLettrePseudoAleatoire();

        } else {
            if (numeroCarte > 26)
            {
                numeroCarte = numeroCarte - 26;
            }
            System.out.println("La lettre pseudo aléatoire est : " + (char)(numeroCarte + 64));
            melangeCartes();
            return numeroCarte;
        }
    }
    public void melangeCartes(){
        reculJokerNoir();
        reculJokerRouge();
        doubleCoupeParRapportAuxJokers();
        coupeSimpleSelonDerniereCarte();
    }
}
