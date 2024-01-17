package com.example.currencyexchange;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import com.google.gson.*;

public class Rate {

    public double[] getRate() throws IOException {
        double[] exchangeRate = new double[0];
        String apiKey = "f913b6adec4ef061c68a6a47";
        String baseCurrency = "SGD"; // Change this to your desired base currency
        String url_str = "https://v6.exchangerate-api.com/v6/f913b6adec4ef061c68a6a47/latest/SGD";

        // Making Request
        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        // Convert to JSON
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();
        JsonObject rates = jsonobj.getAsJsonObject("conversion_rates");

        // Convert rates to double array
        exchangeRate = new double[]{rates.get("USD").getAsDouble(), rates.get("EUR").getAsDouble(), rates.get("JPY").getAsDouble(),
                rates.get("GBP").getAsDouble(), rates.get("AUD").getAsDouble(), rates.get("CAD").getAsDouble(),
                rates.get("CHF").getAsDouble(), rates.get("CNY").getAsDouble()};


        return exchangeRate;
    }
}

