package challenge.conversor.moedas.dto;

import challenge.conversor.moedas.model.exchange.ExchangeErrorModel;
import challenge.conversor.moedas.model.exchange.ExchangeModel;

public  class ExchangeConversionResponse<ExchangeModel> {

    private ExchangeModel exchangeResult;

    public ExchangeConversionResponse(ExchangeModel exchangeResult) {
        this.exchangeResult = exchangeResult;
    }

    public ExchangeModel getExchangeResult() {
        return exchangeResult;
    }
}
