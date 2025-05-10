package challenge.conversor.moedas.config;

public final class ExchangeApiConfig {

    String apiUrl = "https://v6.exchangerate-api.com/v6/0234b7d1a2a84cdaf26c9109";

    public String getUrl() {
        return apiUrl;
    }

    public String getUrl(String baseCode, String targetCode) {
        return  String.format("%s/%s/%s", apiUrl, baseCode.toUpperCase(), targetCode.toUpperCase());
    }

    public String getUrl(String baseCode, String targetCode, double amount) {
        return  String.format("%s/%s/%s/%f", apiUrl, baseCode, targetCode, amount);
    }

}
