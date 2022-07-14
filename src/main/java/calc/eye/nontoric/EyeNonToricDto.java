package calc.eye.nontoric;


import org.json.JSONObject;

public class EyeNonToricDto {

    private String al;
    private String k1;
    private String k2;
    private String acd;
    private String lt;
    private String cct;

    private JSONObject errors;

    public EyeNonToricDto(String al, String k1, String k2, String acd, String lt, String cct) {
        this.al = al;
        this.k1 = k1;
        this.k2 = k2;
        this.acd = acd;
        this.lt = lt;
        this.cct = cct;

        this.errors = new JSONObject();
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
        EyeNonToricValidator validator = new EyeNonToricValidator();

        Boolean isValid = validator.isAlValid(this.al);
        isValid = validator.isK1Valid(this.k1) && isValid;
        isValid = validator.isK2Valid(this.k1, this.k2) && isValid;
        isValid = validator.isAcdValid(this.acd) && isValid;
        isValid = validator.isLtValid(this.lt) && isValid;
        isValid = validator.isCctValid(this.cct) && isValid;

        this.errors = validator.errors();

        return isValid;
    }

    public JSONObject errors() {
        return this.errors;
    }
}
