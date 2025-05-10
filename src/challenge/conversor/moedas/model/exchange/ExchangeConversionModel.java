package challenge.conversor.moedas.model.exchange;

import challenge.conversor.moedas.dto.ExchangeConversionResponse;

public class ExchangeConversionModel {

    private String baseCode;
    private String targetCode;
    private double conversionRate;
    private double conversionResult;

    public ExchangeConversionModel(ExchangeConversionResponse exchange) {
        this.baseCode = exchange.getBaseCode();
        this.targetCode = exchange.getTargetCode();
        this.conversionRate = exchange.getConversionRate();
        this.conversionResult = exchange.getConversionResult();
    }

    public String getBaseCode() {
        return baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public double getConversionResult() {
        return conversionResult;
    }
}
