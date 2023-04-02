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
public String decrypterMessage(String message, Carte carte) {
        String messageDecrypte = "";
        for (int i = 0; i < message.length(); i++) {
            char lettre = message.charAt(i);
            int numeroLettre = (int) lettre;
            int code = carte.lectureLettrePseudoAleatoire();
            System.out.println((char)(code+96));
            int numeroLettreDecryptee = numeroLettre - code;
            char lettreDecryptee;
            if (Character.isUpperCase(lettre)) {
                lettreDecryptee = (char) (numeroLettreDecryptee < 'A' ? numeroLettreDecryptee + 26 : numeroLettreDecryptee);
            } else {
                lettreDecryptee = (char) (numeroLettreDecryptee < 'a' ? numeroLettreDecryptee + 26 : numeroLettreDecryptee);
            }
            messageDecrypte = messageDecrypte + lettreDecryptee;
        }
        return messageDecrypte;
    }
}



