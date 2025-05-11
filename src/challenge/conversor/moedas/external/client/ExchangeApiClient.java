package challenge.conversor.moedas.external.client;

import challenge.conversor.moedas.config.ExchangeApiConfig;
import challenge.conversor.moedas.dto.ExchangeConversionRequest;
import challenge.conversor.moedas.dto.ExchangeConversionResponse;
import challenge.conversor.moedas.model.exchange.ExchangeErrorModel;
import challenge.conversor.moedas.model.exceptions.BadFormatRequestException;
import challenge.conversor.moedas.model.exchange.ExchangeConversionModel;
import challenge.conversor.moedas.model.exchange.ExchangeModel;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeApiClient {

    private final HttpClient _client;

    private final Gson gson = new GsonBuilder().setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

    public ExchangeApiClient() {
        this._client = HttpClient.newHttpClient();
    }

    public ExchangeConversionResponse<ExchangeModel> convert(ExchangeConversionRequest request) {
        ExchangeConversionResponse<ExchangeModel> response = null;

        try {
            if (
                request.getBaseCode().isEmpty() || request.getBaseCode().isBlank()
                || request.getTargetCode().isEmpty() || request.getTargetCode().isBlank()
            ) {
                throw new BadFormatRequestException("Parametros inválidos");
            }

            HttpRequest apiRequest = request.getAmount() == 0.0 ?
                    getRequestPair(request.getBaseCode(), request.getTargetCode()) :
                    getRequestPair(request.getBaseCode(), request.getTargetCode(), request.getAmount());


            var apiResponse = _client.send(apiRequest, HttpResponse.BodyHandlers.ofString());

            if (apiResponse.statusCode() == 200) {
                ExchangeModel model = gson.fromJson(apiResponse.body(), ExchangeConversionModel.class);

                System.out.println(model.toString());
                response = new ExchangeConversionResponse<>(gson.fromJson(apiResponse.body(),  ExchangeConversionModel.class));
            }
            else if (apiResponse.statusCode() == 400) {
                throw new BadFormatRequestException((ExchangeErrorModel) gson.fromJson(apiResponse.body(), ExchangeErrorModel.class));
            }
            else {
                throw new Exception("Falha ao obter retorno da API");
            }

        } catch (BadFormatRequestException ex) {

            response = new ExchangeConversionResponse<>(ex.getError());

        } catch (Exception ex) {

            ExchangeErrorModel error = new ExchangeErrorModel(ex.getMessage());
            response = new ExchangeConversionResponse<>(error);

        }

        return response;
    }

    private HttpRequest getRequestPair(String baseCode, String targetCode) {
        return  HttpRequest.newBuilder().uri(URI.create(ExchangeApiConfig.getUrlPair(baseCode, targetCode))).build();
    }

    private HttpRequest getRequestPair(String baseCode, String targetCode, double amount) {
        return  HttpRequest.newBuilder().uri(URI.create(ExchangeApiConfig.getUrlPair(baseCode, targetCode, amount))).build();
    }

}
