package vue;

/** Classe Ihm */
public class Ihm {
    /*
    Scanner sc = new Scanner(System.in);

    public int getChoixJeu(){
        System.out.println();
        System.out.println("Souhaitez vous faire un chiffrement ou un déchiffrement?");
        System.out.println("1- Chiffrement");
        System.out.println("2- Déchiffrement");
        String message = "Souhaitez vous faire un chiffrement ou un déchiffrement?\n" +
                "1- Chiffrement\n" +
                "2- Déchiffrement\n" +
                "Votre choix: ";
        int choixJeu = this.faireChoix(message,1,2);
        return choixJeu;
    }

    public String getTexteAChiffrer(){
        System.out.println();
        System.out.println("Entrez le texte à chiffrer:");

        String texteAChiffrer = sc.nextLine();
        return texteAChiffrer;
    }

    private int faireChoix (String message,int limiteInf, int limiteSup){
        int choix = 0;
        boolean erreur = true;
        do {
            System.out.print(message);
            try {
                choix = sc.nextInt();
                sc.nextLine();
                if (choix>=limiteInf && choix <= limiteSup){
                    erreur = false;
                }
                else
                    System.out.println("Oops choix impossible");
            }catch (InputMismatchException e ) {
                sc.nextLine();
                System.out.println("Oops choix impossible");
            }
        }while(erreur);
        return choix;
    }*/
}