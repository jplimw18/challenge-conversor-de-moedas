package challenge.conversor.moedas.controller;

import challenge.conversor.moedas.model.exchange.ExchangeConversionModel;
import challenge.conversor.moedas.model.exchange.ExchangeErrorModel;
import challenge.conversor.moedas.model.exchange.ExchangeModel;
import challenge.conversor.moedas.service.ExchangeService;

public class ExchangeController {

    private final ExchangeService _exchange;

    public ExchangeController() {
        this._exchange = new ExchangeService();
    }

    public ExchangeModel convert(String baseCode, String targetCode) {
       return  _exchange.convert(baseCode, targetCode).getExchangeResult();
    }

    public ExchangeModel convert(String baseCode, String targetCode, double amount) {
        return  _exchange.convert(baseCode, targetCode, amount).getExchangeResult();
    }

}
