package calc.eye.toric;

import calc.eye.toric.EyeToricValidator;
import org.json.JSONObject;

public class EyeToricDto {

    private String al;
    private String k1;
    private String k2;
    private String acd;
    private String lt;
    private String cct;
    private String k1_axis;
    private String sia;
    private String incision;
    private EyeToricValidator validator;




    public EyeToricDto(String al, String k1, String k2, String acd,
                String lt, String cct, String k1_axis,
                String sia, String incision) {
        
        this.al = al;
        this.k1 = k1;
        this.k2 = k2;
        this.acd = acd;
        this.lt = lt;
        this.cct = cct;
        this.k1_axis = k1_axis;
        this.sia = sia;
        this.incision = incision;

        this.validator = new EyeToricValidator();
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

    public String getK1axis() {
        return this.k1_axis;
    }

    public String getK2axis() {
        return (Integer.parseInt(k1_axis) + 90 > 180) ?
                Integer.toString(Integer.parseInt(k1_axis) - 90) :
                Integer.toString(Integer.parseInt(k1_axis) + 90);
    }

    public String getSia() {
        return this.sia;
    }

    public String getIncision() {
        return this.incision;
    }

    public boolean isValid() {
        Boolean isValid = this.validator.isAlValid(this.al);
        isValid = this.validator.isK1Valid(this.k1) && isValid;
        isValid = this.validator.isK2Valid(this.k1, this.k2) && isValid;
        isValid = this.validator.isAcdValid(this.acd) && isValid;
        isValid = this.validator.isLtValid(this.lt) && isValid;
        isValid = this.validator.isCctValid(this.cct) && isValid;
        isValid = this.validator.isIncisionValid(this.incision) && isValid;
        isValid = this.validator.isK1axisValid(this.k1) && isValid;
        isValid = this.validator.isSiaValid(this.sia) && isValid;

        return isValid;
    }

    public JSONObject errorLogs() {
        return this.validator.getErrorLog();
    }

    public JSONObject errorMessagesRu() {
        return this.validator.getErrorMessageRu();
    }

}
