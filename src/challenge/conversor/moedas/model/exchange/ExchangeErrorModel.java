package challenge.conversor.moedas.model.exchange;

public class ExchangeErrorModel extends ExchangeModel {

    private String result;
    private String errorType;

    public ExchangeErrorModel(String error) {
        this.result = "error";
        this.errorType = error;
    }

    public String getResult() {
        return result;
    }

    public String getErrorType() {
        return errorType;
    }

    @Override
    public String toString() {
        return String.format("""
                *******************************************************************
                
                %s
                
                *******************************************************************
                """, errorType);
    }
}
