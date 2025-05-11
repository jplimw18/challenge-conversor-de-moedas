package challenge.conversor.moedas.model.exceptions;

import challenge.conversor.moedas.model.exchange.ExchangeErrorModel;

public class BadFormatRequestException extends RuntimeException {

    private ExchangeErrorModel error;

    public ExchangeErrorModel getError() {
      return this.error;
    }

    public BadFormatRequestException(String message) {
        this.error = new ExchangeErrorModel(message);
    }
    public BadFormatRequestException(ExchangeErrorModel error) { this.error = error; }

}
