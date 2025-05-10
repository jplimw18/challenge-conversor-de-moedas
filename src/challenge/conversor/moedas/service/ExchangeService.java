package challenge.conversor.moedas.service;

import challenge.conversor.moedas.dto.ExchangeConversionRequest;
import challenge.conversor.moedas.dto.ExchangeConversionResponse;
import challenge.conversor.moedas.external.client.ExchangeApiClient;
import challenge.conversor.moedas.model.exchange.ExchangeConversionModel;

import java.net.http.HttpResponse;

public class ExchangeService {

    private final ExchangeApiClient _api;

    public ExchangeService(ExchangeApiClient api) {
        this._api = api;
    }

    public ExchangeConversionModel convert(String baseCode, String targetCode) {
        return convert(baseCode, targetCode, 0.0);
    }

    public ExchangeConversionModel convert(String baseCode, String targetCode, double amount) {
        ExchangeConversionRequest request = amount != 0.0 ?
                new ExchangeConversionRequest(baseCode, targetCode, amount) :
                new ExchangeConversionRequest(baseCode, targetCode);

        var response = _api.convert(request);

        if (response.statusCode() == 400) {
            return null;
        }
        else if (response.statusCode() == 500) {
            return null;
        }
        else if (response.statusCode() != 200) {
            return  null;
        }

        return new ExchangeConversionModel(response.body());
    }

}
