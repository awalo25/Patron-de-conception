import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnection {
    public static void main(String[] args) {
        try {
            // URL de la page web contenant le formulaire de connexion
            String urlStr = "http://localhost:3000/index.php";

            // Création de l'objet URL à partir de l'URL de la page web
            URL url = new URL(urlStr);

            // Ouverture de la connexion HTTP
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Configuration de la requête
            connection.setRequestMethod("GET");

            // Envoi de la requête
            int responseCode = connection.getResponseCode();

            // Vérification de la réponse du serveur
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Lecture de la réponse du serveur
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();

                // Affichage de la réponse
                System.out.println("Contenu de la page web :");
                System.out.println(response.toString());
            } else {
                System.out.println("La requête a échoué. Code de réponse : " + responseCode);
            }

            // Fermeture de la connexion
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
