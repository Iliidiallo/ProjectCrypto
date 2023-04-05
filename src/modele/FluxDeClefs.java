package modele;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FluxDeClefs {
    private List<Integer> codes;

    public FluxDeClefs() {
        codes = new ArrayList<>();
    }

    //methode pour crypter un message
   public String crypterMessage(String message, Carte carte){
        ArrayList<Character> caracSpeciale = new ArrayList<>();
        caracSpeciale.add('é');
        caracSpeciale.add('è');
        caracSpeciale.add('œ');
        caracSpeciale.add('ê');
        caracSpeciale.add('ù');
       codes.clear();
       String messageCrypte = "";
       for (int i = 0; i < message.length(); i++) {
           char lettre = message.charAt(i);
           if (caracSpeciale.contains(lettre)){
               lettre = '&';
           }
           if (Character.isLetter(lettre)) {
               int numeroLettre = (int) lettre;
               int code = carte.lectureLettrePseudoAleatoire();
               codes.add(code);
               int numeroLettreCryptee = numeroLettre + code;
               char lettreCryptee;
               if (Character.isUpperCase(lettre) ) {
                   lettreCryptee = (char) (numeroLettreCryptee > 'Z' ? numeroLettreCryptee - 26 : numeroLettreCryptee);
               } else {
                   lettreCryptee = (char) (numeroLettreCryptee > 'z' ? numeroLettreCryptee - 26 : numeroLettreCryptee);
               }
               messageCrypte = messageCrypte + lettreCryptee;
           }
       }
       return messageCrypte;
   }

   //methode pour crypter un Fichier
   public String crypterFichier(String cheminVersFichier, Carte carte) {
       try {
           FileReader fileReader = new FileReader(cheminVersFichier);
           BufferedReader bufferedReader = new BufferedReader(fileReader);
           String ligne;
           String messageCrypte = "";
           while ((ligne = bufferedReader.readLine()) != null) {
               messageCrypte += this.crypterMessage(ligne, carte) + "\n";
           }
           bufferedReader.close();

           FileWriter fileWriter = new FileWriter(cheminVersFichier+"_crypte" + ".txt");
           BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
           bufferedWriter.write(messageCrypte);
           bufferedWriter.close();


           return messageCrypte;
       } catch (IOException e) {
           e.printStackTrace();
           return "";
       }
   }





//methode pour decrypter un message
    public String decrypterMessage(String message) {
        String messageDecrypte = "";
        int indexCode = 0;
        for (int i = 0; i < message.length(); i++) {
            char lettre = message.charAt(i);
            if (Character.isLetter(lettre)) {
                int numeroLettreCryptee = (int) lettre;
                int code = this.codes.get(indexCode);
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
//methode pour decrypter un fichier
public String decrypteFichier(String fichierCrypte) {
    String fichierDecrypte = "";
    try {
        Scanner scanner = new Scanner(new File(fichierCrypte));
        while (scanner.hasNextLine()) {
            String ligne = scanner.nextLine();
            System.out.println(ligne);
            fichierDecrypte += decrypterMessage(ligne) + "\n";
        }
        scanner.close();
    } catch (FileNotFoundException e) {
        System.out.println("Le fichier n'a pas été trouvé : " + e.getMessage());
    }
    return fichierDecrypte;
}


}




