package com.example.currencyexchange;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class Rate {

    public double[] getRate() {
        double[] exchangeRate = new double[0];
        String apiKey = "48d009c6817a497aa1e95070217e329a";
        String baseCurrency = "SGD"; // Change this to your desired base currency

        try {
            URL url = new URL("https://open.er-api.com/v6/latest/" + baseCurrency);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            connection.disconnect();

            // Parse JSON response and extract the rate for the target currency
            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONObject rates = jsonResponse.getJSONObject("rates");
            exchangeRate = new double[] {rates.getDouble("USD"), rates.getDouble("EUR"), rates.getDouble("JPY"), rates.getDouble("GBP"),
                    rates.getDouble("AUD"), rates.getDouble("CAD"), rates.getDouble("CHF"), rates.getDouble("CNY")};
        } catch (Exception e) {
            e.printStackTrace();
        }

        return exchangeRate;
    }
}

