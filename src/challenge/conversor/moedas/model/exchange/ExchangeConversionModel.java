package challenge.conversor.moedas.model.exchange;

public class ExchangeConversionModel {

    private String baseCode;
    private String targetCode;
    private double conversionRate;
    private double amount;

    public String getBaseCode() {
        return baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public double getAmount() {
        return amount;
    }

    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }

    public void setTargetCode(String targetCode) {
        this.targetCode = targetCode;
    }

    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
