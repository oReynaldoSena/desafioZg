import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.*;


public class POST {

    public static void main(String[] args) {
        try {
            // URL do endpoint do Passo 2
            String url = "https://desafio-endpoint-hashcode-n2.onrender.com/passo2";

            // Cria o objeto URL
            URL obj = new URL(url);

            // Abre a conexão
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // Define o método de requisição como POST
            con.setRequestMethod("POST");

            // Definir o cabeçalho como JSON
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");

            // Habilita o envio de dados no corpo da requisição
            con.setDoOutput(true);

            // Cria o JSON com o CPF
            JSONObject jsonInput = new JSONObject();
            jsonInput.put("cpf", "***.***.***-**");  // Substitua pelo seu CPF

            // Envia o JSON no corpo da requisição
            try (OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInput.toString().getBytes("utf-8");
                os.write(input, 0, input.length);
            }

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
