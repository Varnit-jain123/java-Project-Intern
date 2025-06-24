import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WeatherClient {
    public static void main(String[] args) {
        String latitude = "28.6139";
        String longitude = "77.2090";
        String apiUrl = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude + "&longitude=" + longitude + "&current_weather=true";

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder responseBuilder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line);
            }

            reader.close();
            String response = responseBuilder.toString();

            JsonObject jsonObject = JsonParser.parseString(response).getAsJsonObject();
            JsonObject currentWeather = jsonObject.getAsJsonObject("current_weather");

            String temperature = currentWeather.get("temperature").getAsString();
            String windSpeed = currentWeather.get("windspeed").getAsString();
            String time = currentWeather.get("time").getAsString();

            System.out.println("Current Weather in Delhi:");
            System.out.println("Temperature: " + temperature + "C");
            System.out.println("Wind Speed: " + windSpeed + " km/h");
            System.out.println("Time: " + time);
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
