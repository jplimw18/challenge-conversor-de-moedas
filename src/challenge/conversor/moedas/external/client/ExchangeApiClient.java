package challenge.conversor.moedas.external.client;

import challenge.conversor.moedas.config.ExchangeApiConfig;

import java.net.http.HttpClient;

public class ExchangeApiClient {

    private final HttpClient _client;
    private final ExchangeApiConfig _apiConfig;

    public ExchangeApiClient(ExchangeApiConfig apiConfig) {
        this._client = HttpClient.newHttpClient();
        this._apiConfig = apiConfig;
    }

}
