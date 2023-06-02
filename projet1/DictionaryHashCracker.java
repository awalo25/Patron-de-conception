package projet1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DictionaryHashCracker implements PasswordCrackerMode {
    @Override
    public void crackPassword(String hashedPassword) {
        System.out.println("Mode Hash Dictionary Cracker");
        String filePath = "C:/Users/bmd tech/OneDrive/Bureau/Projet1/dictionnarycrack.txt";
        Map<String, String> dictionary = readDictionary(filePath);

        String password = dictionary.get(hashedPassword);
        if (password != null) {
            System.out.println("Mot de passe trouve : " + password);
        } else {
            System.out.println("Mot de passe non trouve !");
        }
    }

    private Map<String, String> readDictionary(String filePath) {
        Map<String, String> dictionary = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String password = parts[0];
                    String hashedPassword = parts[1];
                    dictionary.put(password, hashedPassword); // Inverser les clés et les valeurs
                }
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }

        return dictionary;
    }
}
