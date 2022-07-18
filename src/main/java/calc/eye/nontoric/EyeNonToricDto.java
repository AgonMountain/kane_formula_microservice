package calc.eye.nontoric;


import org.json.JSONObject;


public class EyeNonToricDto {

    private String al;
    private String k1;
    private String k2;
    private String acd;
    private String lt;
    private String cct;
    private EyeNonToricValidator validator;




    public EyeNonToricDto(String al, String k1, String k2, String acd, String lt, String cct) {
        this.al = al;
        this.k1 = k1;
        this.k2 = k2;
        this.acd = acd;
        this.lt = lt;
        this.cct = cct;

        this.validator = new EyeNonToricValidator();
    }

    public String getAl() {
        return this.al;
    }

    public String getK1() {
        return this.k1;
    }

    public String getK2() {
        return this.k2;
    }

    public String getAcd() {
        return this.acd;
    }

    public String getLt() {
        return this.lt;
    }

    public String getCct() {
        return this.cct;
    }

    public boolean isValid() {
        Boolean isValid = this.validator.isAlValid(this.al);
        isValid = this.validator.isK1Valid(this.k1) && isValid;
        isValid = this.validator.isK2Valid(this.k1, this.k2) && isValid;
        isValid = this.validator.isAcdValid(this.acd) && isValid;
        isValid = this.validator.isLtValid(this.lt) && isValid;
        isValid = this.validator.isCctValid(this.cct) && isValid;

        return isValid;
    }

    public JSONObject errorLogs() {
        return this.validator.getErrorLog();
    }

    public JSONObject errorMessagesRu() {
        return this.validator.getErrorMessageRu();
    }
}
