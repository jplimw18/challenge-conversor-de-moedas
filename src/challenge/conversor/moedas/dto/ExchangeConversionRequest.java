package challenge.conversor.moedas.dto;

public class ExchangeConversionRequest {

    private String baseCode;
    private String targetCode;
    private Double amount;

    public ExchangeConversionRequest(String baseCode, String targetCode) {
        this.baseCode = baseCode;
        this.targetCode = targetCode;
    }

    public ExchangeConversionRequest(String baseCode, String targetCode, double amount) {
        this.baseCode = baseCode;
        this.targetCode = targetCode;
        this.amount = amount;
    }

}
