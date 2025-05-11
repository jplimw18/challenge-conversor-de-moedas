package challenge.conversor.moedas.model.exchange;

public class ExchangeErrorModel extends ExchangeModel {


    private String errorType;

    public ExchangeErrorModel(String error) {
        super.setResult("error");
        this.errorType = error;
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
