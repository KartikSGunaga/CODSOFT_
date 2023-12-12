package task04;

import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

// APIKey = 1fce64b3818e458cbee6a223dd39132f
public class CurrencyConverter {
    private final String key;
    private String baseCurrency;
    private String targetCurrency;
    public CurrencyConverter(String key, String baseCurrency, String targetCurrency){
        this.key = key;
        this.baseCurrency = baseCurrency;
        this.targetCurrency = targetCurrency;
    }
    public double fetchCurrencyValue(double amount) throws Exception{
        HttpClient client = HttpClient.newHttpClient();

        String address = "https://api.currencyfreaks.com/v2.0/rates/latest" +
                "?apikey=" + this.key +
                "&symbols=" + this.baseCurrency + "," + this.targetCurrency +
                "&base=" + this.baseCurrency;

        URI uri = new URI(address);


        HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if(response.statusCode() == 200){
            JSONObject obj = new JSONObject(response.body());
            JSONObject rates = obj.getJSONObject(("rates"));

            // double baseCurrency = obj.getJSONObject("main").getDouble(this.baseCurrency);
            double targetCurrency = rates.getDouble(this.targetCurrency);

            return amount * targetCurrency;

        }
        else {
            throw new RuntimeException("Error calling API. Response = " + response.body());
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Kartik's Currency Converter!");
        System.out.println("\nPlease enter the API Key: ");
        String key = scanner.next();



        while(true) {
            System.out.println("Enter the Base Currency Denomination: ");
            String baseCurrency = scanner.next();
            System.out.println("Enter the amount(type double) you wish to convert: ");
            double amount = scanner.nextDouble();
            System.out.println("Enter the Target Currency Denomination: ");
            String targetCurrency = scanner.next();

            CurrencyConverter currency = new CurrencyConverter(key, baseCurrency, targetCurrency);
            double convertedAmount = currency.fetchCurrencyValue(amount);

            System.out.println(baseCurrency + " " + amount + " = "  + targetCurrency + " " + convertedAmount);

            System.out.println("Do you wish to convert currency again?(yes or no): ");
            String choice = scanner.next().toLowerCase();

            if (choice.equals("no")) {
                System.out.println("Thank you for using Kartik's Currency converter! \n" +
                        "Hope it helped!");
                break;
            }
        }
    }
}
