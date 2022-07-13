package calc;

import org.json.JSONObject;

public class EyeToricDto {

    private String al;
    private String k1;
    private String k2;
    private String acd;
    private String lt;
    private String cct;
    private String k1_axis;
    private String k2_axis;
    private String sia;
    private String incision;

    EyeToricDto(String al, String k1, String k2, String acd,
                String lt, String cct, String k1_axis, String k2_axis,
                String sia, String incision) {
        
        this.al = al;
        this.k1 = k1;
        this.k2 = k2;
        this.acd = acd;
        this.lt = lt;
        this.cct = cct;
        this.k1_axis = k1_axis;
        this.k2_axis = k2_axis;
        this.sia = sia;
        this.incision = incision;
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
        return this.k2_axis;
    }

    public String getSia() {
        return this.sia;
    }

    public String getIncision() {
        return this.incision;
    }

}
