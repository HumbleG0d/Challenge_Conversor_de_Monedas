package org.view.Models;

import com.google.gson.*;
import org.view.Logical.AllCoins;
import org.view.Services.ConsumirAPI;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Map;


public class BDD {
  public Map<String, Object> getCoins(ConsumirAPI api) throws IOException, InterruptedException {

    Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();
    Gson gson2 = new Gson();

    AllCoins allCoins = gson.fromJson(api.getRequest() ,AllCoins.class);
    //JsonObject jsonObject = gson2.fromJson(allCoins.conversion_rates().toString(), JsonObject.class);
    Map<String , Object>  map = gson2.fromJson(allCoins.conversion_rates().toString(), Map.class);
    return map;
  }

  public Map<String , Object> getCurrencyCode() throws FileNotFoundException {
    String file = "C:\\Users\\sergi\\OneDrive\\Escritorio\\Challenge_Conversor_de_Monedas\\Conversor_Monedas\\src\\main\\java\\org\\view\\JSON\\Curreny_Code.json";
    Gson gson = new Gson();
    Reader reader = new FileReader(file);
    JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
    Map<String, Object> map = gson.fromJson(jsonObject, Map.class);
    return map;
  }
}
