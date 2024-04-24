package org.view.Models;

import com.google.gson.*;
import org.view.Logic.AllCoins;
import org.view.Services.ConsumirAPI;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Map;

public class Data {

  private final ConsumirAPI api; //Variable que almacena la instancia de la clase ConsumirAPI

  //Constructor de la clase
  public Data() {
    this.api = new ConsumirAPI(System.getenv("API_KEY"));
  }

  //Método que obtiene las monedas
  public Map<String, Object> getCoins() throws IOException, InterruptedException {

    Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();
    Gson gson2 = new Gson();

    AllCoins allCoins = gson.fromJson(api.getRequest() ,AllCoins.class);
    Map<String , Object>  map = gson2.fromJson(allCoins.conversion_rates().toString(), Map.class);
    return map;
  }

  //Método que obtiene el código de la moneda
  public Map<String , Object> getCurrencyCode() throws FileNotFoundException {
    String file = "C:\\Users\\sergi\\OneDrive\\Escritorio\\Challenge_Conversor_de_Monedas\\Conversor_Monedas\\src\\main\\java\\org\\view\\JSON\\Curreny_Code.json";
    Gson gson = new Gson();
    Reader reader = new FileReader(file);
    JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
    Map<String, Object> map = gson.fromJson(jsonObject, Map.class);
    return map;
  }
}
