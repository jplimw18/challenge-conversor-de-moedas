package challenge.conversor.moedas.model.exchange;

public class ExchangeConversionModel extends ExchangeModel {

    private String documentation;
    private String termsOfUse;
    private Long timeLastUpdateUnix;
    private String timeLastUpdateUtc;
    private Long timeNextUpdateUnix;
    private String timeNextUpdateUtc;
    private String baseCode;
    private String targetCode;
    private Double conversionRate;
    private Double conversionResult;


    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public String getTermsOfUse() {
        return termsOfUse;
    }

    public void setTermsOfUse(String termsOfUse) {
        this.termsOfUse = termsOfUse;
    }

    public Long getTimeLastUpdateUnix() {
        return timeLastUpdateUnix;
    }

    public void setTimeLastUpdateUnix(Long timeLastUpdateUnix) {
        this.timeLastUpdateUnix = timeLastUpdateUnix;
    }

    public String getTimeLastUpdateUtc() {
        return timeLastUpdateUtc;
    }

    public void setTimeLastUpdateUtc(String timeLastUpdateUtc) {
        this.timeLastUpdateUtc = timeLastUpdateUtc;
    }

    public Long getTimeNextUpdateUnix() {
        return timeNextUpdateUnix;
    }

    public void setTimeNextUpdateUnix(Long timeNextUpdateUnix) {
        this.timeNextUpdateUnix = timeNextUpdateUnix;
    }

    public String getTimeNextUpdateUtc() {
        return timeNextUpdateUtc;
    }

    public void setTimeNextUpdateUtc(String timeNextUpdateUtc) {
        this.timeNextUpdateUtc = timeNextUpdateUtc;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public void setTargetCode(String targetCode) {
        this.targetCode = targetCode;
    }

    public Double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(Double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public Double getConversionResult() {
        return conversionResult;
    }

    public void setConversionResult(Double conversionResult) {
        this.conversionResult = conversionResult;
    }

    @Override
    public String getResult() {
        return super.getResult();
    }

    @Override
    public void setResult(String result) {
        super.setResult(result);
    }

    @Override
    public String toString() {
        return String.format("""
                Valor %.2f [%s] corresponde ao valor final de ---> %.2f [%s] 
                """, conversionResult / conversionRate, baseCode, conversionResult, targetCode);

    }

}
