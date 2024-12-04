import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GETpasso4 {
    public static void main(String[] args) {
        try {
            // Parâmetros da requisição
            String cpf = "***.***.***-**";  // CPF
            String token = "c8bd7301fb7a3f5adb054936d68ebc2ea09aa6b4";  // Token obtido no Passo 3

            // URL do endpoint do Passo 4 com os parâmetros
            String url = "https://desafio-endpoint-hashcode-n2.onrender.com/passo4?cpf=" + cpf + "&token=" + token;

            // Cria o objeto URL
            URL obj = new URL(url);

            // Abre a conexão
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // Define o método de requisição como GET
            con.setRequestMethod("GET");

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

            // Exibe a resposta
            System.out.println("Resposta: " + response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
