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

    private JSONObject errors;

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
        EyeToricValidator validator = new EyeToricValidator();

        Boolean isValid = validator.isAlValid(this.al);
        isValid = validator.isK1Valid(this.k1) && isValid;
        isValid = validator.isK2Valid(this.k1, this.k2) && isValid;
        isValid = validator.isAcdValid(this.acd) && isValid;
        isValid = validator.isLtValid(this.lt) && isValid;
        isValid = validator.isCctValid(this.cct) && isValid;
        isValid = validator.isIncisionValid(this.incision) && isValid;
        isValid = validator.isK1axisValid(this.k1) && isValid;
        isValid = validator.isSiaValid(this.sia) && isValid;

        //&& validator.isK2axisValid(this.k2)); // TODO check KaneFormulaValidator isK2axisValid()

        this.errors = validator.errors();

        return isValid;
    }

    public JSONObject errors() {
        return this.errors;
    }

}
