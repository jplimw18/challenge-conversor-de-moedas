package challenge.conversor.moedas.external.client;

import challenge.conversor.moedas.config.ExchangeApiConfig;
import challenge.conversor.moedas.dto.ExchangeConversionRequest;
import challenge.conversor.moedas.dto.ExchangeConversionResponse;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.net.ssl.SSLSession;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

public class ExchangeApiClient {

    private final ExchangeApiConfig _apiConfig;
    private final HttpClient _client;

    private final Gson gson = new GsonBuilder().setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

    public ExchangeApiClient(ExchangeApiConfig apiConfig) {
        this._client = HttpClient.newHttpClient();
        this._apiConfig = apiConfig;
    }

    public HttpResponse<ExchangeConversionResponse> convert(ExchangeConversionRequest request) {
            if (
                request.getBaseCode().isEmpty() || request.getBaseCode().isBlank()
                || request.getTargetCode().isEmpty() || request.getTargetCode().isBlank()
            ) {
                return new HttpResponse<ExchangeConversionResponse>() {
                    @Override
                    public int statusCode() {
                        return 400;
                    }

                    @Override
                    public HttpRequest request() {
                        return null;
                    }

                    @Override
                    public Optional<HttpResponse<ExchangeConversionResponse>> previousResponse() {
                        return Optional.empty();
                    }

                    @Override
                    public HttpHeaders headers() {
                        return null;
                    }

                    @Override
                    public ExchangeConversionResponse body() {
                        return null;
                    }

                    @Override
                    public Optional<SSLSession> sslSession() {
                        return Optional.empty();
                    }

                    @Override
                    public URI uri() {
                        return null;
                    }

                    @Override
                    public HttpClient.Version version() {
                        return null;
                    }
                };
            }

            HttpRequest apiRequest = request.getAmount() == 0.0 ?
                    getRequest(request.getBaseCode(), request.getTargetCode()) :
                    getRequest(request.getBaseCode(), request.getTargetCode(), request.getAmount());

            HttpResponse<ExchangeConversionResponse> response;
            try {
               response = gson.fromJson(_client.send(apiRequest, HttpResponse.BodyHandlers.ofString()).body(), (Type) ExchangeConversionResponse.class);
            } catch (Exception ex) {
                return new HttpResponse<ExchangeConversionResponse>() {
                    @Override
                    public int statusCode() {
                        return 500;
                    }

                    @Override
                    public HttpRequest request() {
                        return null;
                    }

                    @Override
                    public Optional<HttpResponse<ExchangeConversionResponse>> previousResponse() {
                        return Optional.empty();
                    }

                    @Override
                    public HttpHeaders headers() {
                        return null;
                    }

                    @Override
                    public ExchangeConversionResponse body() {
                        return null;
                    }

                    @Override
                    public Optional<SSLSession> sslSession() {
                        return Optional.empty();
                    }

                    @Override
                    public URI uri() {
                        return null;
                    }

                    @Override
                    public HttpClient.Version version() {
                        return null;
                    }
                };
            }

            return response;
    }

    private HttpRequest getRequest(String baseCode, String targetCode) {
        return  HttpRequest.newBuilder().uri(URI.create(_apiConfig.getUrl(baseCode, targetCode))).build();
    }

    private HttpRequest getRequest(String baseCode, String targetCode, double amount) {
        return  HttpRequest.newBuilder().uri(URI.create(_apiConfig.getUrl(baseCode, targetCode, amount))).build();
    }

}
