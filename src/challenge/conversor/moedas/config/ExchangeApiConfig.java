package challenge.conversor.moedas.config;

public final class ExchangeApiConfig {

    static String apiUrl = "https://v6.exchangerate-api.com/v6/0234b7d1a2a84cdaf26c9109";

    public static String getUrlPair(String baseCode, String targetCode) {
        return  String.format("%s/pair/%s/%s", apiUrl, baseCode.toUpperCase(), targetCode.toUpperCase());
    }

    public static String getUrlPair(String baseCode, String targetCode, Double amount) {
        return  String.format("%s/pair/%s/%s/%s", apiUrl, baseCode, targetCode, amount.toString().replace(',', '.'));
    }

}
