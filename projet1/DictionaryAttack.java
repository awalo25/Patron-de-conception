package projet1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DictionaryAttack implements PasswordCrackerMode {
    @Override
    public void crackPassword(String password) {
        // Chemin vers le fichier contenant le dictionnaire
        String dictionaryFile = "C:/Users/bmd tech/OneDrive/Bureau/Projet1/dictionnarycrack.txt"; // Remplacez avec le
                                                                                                  // chemin correct

        try (BufferedReader reader = new BufferedReader(new FileReader(dictionaryFile))) {
            String word;
            boolean passwordFound = false;

            // Parcourt le dictionnaire ligne par ligne
            while ((word = reader.readLine()) != null) {
                // Compare le mot courant avec le mot de passe saisi (ignorant la casse)
                if (word.equalsIgnoreCase(password)) {
                    System.out.println("Le mot de passe a ete trouve : " + word);
                    passwordFound = true;
                    break;
                }
            }

            if (!passwordFound) {
                System.out.println("Le mot de passe est incorrect.");
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }
}
