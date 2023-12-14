package task04;

import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

public class CurrencyConverter_ExchangeRateAPI {

    // APIKey = fface0495a0ebf7bf9a916e0
    private final String key;
    private final String baseCurrency;
    private final String targetCurrency;
    public CurrencyConverter_ExchangeRateAPI(String key, String baseCurrency, String targetCurrency) {
            this.key = key;
            this.baseCurrency = baseCurrency;
            this.targetCurrency = targetCurrency;
        }
        public double fetchCurrencyValue(double amount) throws Exception{
            HttpClient client = HttpClient.newHttpClient();

            String address = "https://v6.exchangerate-api.com/v6/"
                    + this.key + "/pair/" +
                     this.baseCurrency + "/"
                    + this.targetCurrency + "/" + amount;

            URI uri = new URI(address);

            HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() == 200){
                JSONObject obj = new JSONObject(response.body());
                double conversion_result = obj.getDouble("conversion_result");
//                String timeLastUpdate = obj.getString("time_last_update_utc");
//              double targetCurrency = conversion_result.getDouble(this.targetCurrency);

                return conversion_result;

            }
            else {
                throw new RuntimeException("Error calling API. Response = " + response.body());
            }
        }

        public String fetchTimeStamp(double amount) throws Exception{
            HttpClient client = HttpClient.newHttpClient();

            String URL = "https://v6.exchangerate-api.com/v6/"
                    + this.key + "/pair/" +
                    this.baseCurrency + "/"
                    + this.targetCurrency + "/" + amount;

            URI uri = new URI(URL);

            HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().build();
            HttpResponse <String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() == 200){
                JSONObject obj = new JSONObject(response.body());
                String timeStamp = obj.getString("time_last_update_utc");

                SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z");
                Date utcDate = dateFormat.parse(timeStamp);
                dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                String utcDateString = dateFormat.format(utcDate);
                dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
                Date istDate = dateFormat.parse(utcDateString);

                return dateFormat.format(istDate);
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
                System.out.println("Enter the Base Currency abbreviation: ");
                String baseCurrency = scanner.next().toUpperCase();
                System.out.println("Enter the amount(type double) in " + baseCurrency +" you wish to convert: ");
                double amount = scanner.nextDouble();
                System.out.println("Enter the Target Currency abbreviation: ");
                String targetCurrency = scanner.next().toUpperCase();

                CurrencyConverter_ExchangeRateAPI currency = new CurrencyConverter_ExchangeRateAPI(key, baseCurrency, targetCurrency);
                double convertedAmount = currency.fetchCurrencyValue(amount);

                CurrencyConverter_ExchangeRateAPI getTimeStamp = new CurrencyConverter_ExchangeRateAPI(key, baseCurrency, targetCurrency);
                String timeStamp = getTimeStamp.fetchTimeStamp(amount);

                System.out.println("As per latest exchange rate fetched at local time " + timeStamp + " :");
                System.out.println(baseCurrency + " " + amount + " = "  + targetCurrency + " " + convertedAmount);

                System.out.println("\nDo you wish to convert currency again?(yes or no): ");
                String choice = scanner.next().toLowerCase();

                if (choice.equals("no")) {
                    System.out.println("""

                            Thank you for using Kartik's Currency converter!\s
                            Hope it helped!""");
                    break;
                }
            }
        }
    }

