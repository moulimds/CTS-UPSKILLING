import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HTTPClient {
    public static void main(String[] args) {
        try {
            // Create HttpClient
            HttpClient client = HttpClient.newHttpClient();

            // Build HttpRequest to GitHub API (example: fetch user info)
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.github.com/users/octocat"))
                    .GET()
                    .build();

            // Send the request and get HttpResponse
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Print status code
            System.out.println("Status Code: " + response.statusCode());

            // Print response body
            System.out.println("Response Body:\n" + response.body());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
