package org.view.Services;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumirAPI {
  //Variable que almacena la clave de la API
  private final String apikey;

  //Constructor de la clase
  public ConsumirAPI(String apikey) {
   if (apikey == null) { //Validación de la clave de la API
        throw new IllegalArgumentException("API_KEY is required");
   }
    this.apikey = apikey; //Asignación de la clave de la API
  }

  //Método que consume la API
  public String getRequest() throws IOException, InterruptedException {
    String url = "https://v6.exchangerate-api.com/v6/" + this.apikey + "/latest/USD";
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
      .uri(java.net.URI.create(url))
      .build();
    HttpResponse<String> response = client
            .send(request, HttpResponse.BodyHandlers.ofString());
    return response.body();
  }
}
