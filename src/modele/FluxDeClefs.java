package modele;

public class FluxDeClefs {

    public String crypterMessage(String message, Carte carte) {
        String messageCrypte = "";
        for (int i = 0; i < message.length(); i++) {
            char lettre = message.charAt(i);
            int numeroLettre = (int) lettre;
            int code = carte.lectureLettrePseudoAleatoire();
            System.out.println((char)(code+96));
            int numeroLettreCryptee = numeroLettre + code;
            char lettreCryptee;
            if (Character.isUpperCase(lettre)) {
                lettreCryptee = (char) (numeroLettreCryptee > 'Z' ? numeroLettreCryptee - 26 : numeroLettreCryptee);
            } else {
                lettreCryptee = (char) (numeroLettreCryptee > 'z' ? numeroLettreCryptee - 26 : numeroLettreCryptee);
            }
            messageCrypte = messageCrypte + lettreCryptee;
        }
        return messageCrypte;
    }


}

