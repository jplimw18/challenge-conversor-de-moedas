package challenge.conversor.moedas.dto;

public class ExchangeConversionRequest {

    private String baseCode;
    private String targetCode;
    private Double amount;

    public ExchangeConversionRequest(String baseCode, String targetCode) {
        this.baseCode = baseCode;
        this.targetCode = targetCode;
        this.amount = 0.0;
    }

    public ExchangeConversionRequest(String baseCode, String targetCode, double amount) {
        this.baseCode = baseCode;
        this.targetCode = targetCode;
        this.amount = amount;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public Double getAmount() {
        return amount;
    }
}
