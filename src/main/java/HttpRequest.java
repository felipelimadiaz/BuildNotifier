import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequest {

    private void sendGet(String url) throws Exception{
        String agent = "";
        URL httpURL = new URL(url);
        HttpURLConnection connection = (HttpURLConnection)httpURL.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", agent);

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = reader.readLine()) != null) {
            response.append(inputLine);
        }
        reader.close();

    }
}
