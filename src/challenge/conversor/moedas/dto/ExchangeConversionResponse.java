package challenge.conversor.moedas.dto;

import java.time.OffsetDateTime;

public class ExchangeConversionResponse {

    private String result;
    private String documentation;
    private String termsOfUse;
    private Long timeLastUpdateUnix;
    private OffsetDateTime timeLastUpdateUtc;
    private Long timeNextUpdateUnix;
    private OffsetDateTime timeNextUpdateUtc;
    private String baseCode;
    private String targetCode;
    private Double conversionRate;
    private Double conversionResult;

    public String getResult() {
        return result;
    }

    public String getDocumentation() {
        return documentation;
    }

    public String getTermsOfUse() {
        return termsOfUse;
    }

    public Long getTimeLastUpdateUnix() {
        return timeLastUpdateUnix;
    }

    public OffsetDateTime getTimeLastUpdateUtc() {
        return timeLastUpdateUtc;
    }

    public Long getTimeNextUpdateUnix() {
        return timeNextUpdateUnix;
    }

    public OffsetDateTime getTimeNextUpdateUtc() {
        return timeNextUpdateUtc;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public Double getConversionRate() {
        return conversionRate;
    }

    public Double getConversionResult() {
        return conversionResult;
    }
}
