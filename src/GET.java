import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class GET {


        public static void main(String[] args) {
            try {
                // URL do endpoint
                String url = "https://desafio-endpoint-hashcode-n2.onrender.com/passo1";

                // Cria o objeto URL
                URL obj = new URL(url);

                // Abre a conexão
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();

                // Define o método de requisição como GET
                con.setRequestMethod("GET");

                // Adiciona cabeçalhos, se necessário
                con.setRequestProperty("User-Agent", "Mozilla/5.0");

                // Verifica o código de resposta HTTP
                int responseCode = con.getResponseCode();
                System.out.println("Resposta HTTP: " + responseCode);

                // Lê a resposta da requisição
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Exibe o corpo da resposta
                System.out.println("Resposta: " + response.toString());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }