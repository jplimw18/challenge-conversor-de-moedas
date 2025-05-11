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

    @Override
    public String toString() {
        return String.format("""
                Valor %.2f [%s] corresponde ao valor final de ---> %.2f [%s] 
                """, conversionResult / conversionRate, baseCode, conversionResult, targetCode);
    }
}
