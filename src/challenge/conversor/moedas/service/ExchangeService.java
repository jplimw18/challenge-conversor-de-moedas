package challenge.conversor.moedas.service;

import challenge.conversor.moedas.config.ExchangeApiConfig;
import challenge.conversor.moedas.dto.ExchangeConversionRequest;
import challenge.conversor.moedas.dto.ExchangeConversionResponse;
import challenge.conversor.moedas.external.client.ExchangeApiClient;
import challenge.conversor.moedas.model.exchange.ExchangeConversionModel;
import challenge.conversor.moedas.model.exchange.ExchangeModel;

import java.net.http.HttpResponse;

public class ExchangeService {

    private final ExchangeApiClient _api;

    public ExchangeService() {
        this._api = new ExchangeApiClient();
    }


    public ExchangeConversionResponse<ExchangeModel> convert(String baseCode, String targetCode) {
        return convert(baseCode, targetCode, 0.0);
    }

    public ExchangeConversionResponse<ExchangeModel> convert(String baseCode, String targetCode, double amount) {
        ExchangeConversionRequest request = amount != 0.0 ?
                new ExchangeConversionRequest(baseCode, targetCode, amount) :
                new ExchangeConversionRequest(baseCode, targetCode);

        return _api.convert(request);
    }

}
