package modele;

import java.util.ArrayList;
import java.util.List;

public class FluxDeClefs {
    private List<Integer> codes;

    public FluxDeClefs() {
        codes = new ArrayList<>();
    }
   public String crypterMessage(String message, Carte carte) {
       String messageCrypte = "";
       for (int i = 0; i < message.length(); i++) {
           char lettre = message.charAt(i);
           if (Character.isLetter(lettre)) {
               int numeroLettre = (int) lettre;
               int code = carte.lectureLettrePseudoAleatoire();
               codes.add(code);
               int numeroLettreCryptee = numeroLettre + code;
               char lettreCryptee;
               if (Character.isUpperCase(lettre)) {
                   lettreCryptee = (char) (numeroLettreCryptee > 'Z' ? numeroLettreCryptee - 26 : numeroLettreCryptee);
               } else {
                   lettreCryptee = (char) (numeroLettreCryptee > 'z' ? numeroLettreCryptee - 26 : numeroLettreCryptee);
               }
               messageCrypte = messageCrypte + lettreCryptee;
           }
       }
       return messageCrypte;
   }

    public String decrypterMessage(String message) {
        String messageDecrypte = "";
        int indexCode = 0;
        for (int i = 0; i < message.length(); i++) {
            char lettre = message.charAt(i);
            if (Character.isLetter(lettre)) {
                int numeroLettreCryptee = (int) lettre;
                int code = codes.get(indexCode);
                int numeroLettre = numeroLettreCryptee - code;
                char lettreDecryptee;
                if (Character.isUpperCase(lettre)) {
                    lettreDecryptee = (char) (numeroLettre < 'A' ? numeroLettre + 26 : numeroLettre);
                } else {
                    lettreDecryptee = (char) (numeroLettre < 'a' ? numeroLettre + 26 : numeroLettre);
                }
                messageDecrypte = messageDecrypte + lettreDecryptee;
                indexCode++;
            }
        }
        return messageDecrypte;
    }

}




