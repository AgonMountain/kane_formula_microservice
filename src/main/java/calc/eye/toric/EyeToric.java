package calc.eye.toric;

import org.json.JSONObject;

import java.io.IOException;
import java.text.ParseException;


public class EyeToric {

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




    public EyeToric(String al, String k1, String k1_axis, String k2, String k2_axis,
             String acd, String lt, String cct, String incision, String sia) {
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

    public JSONObject toJson() throws ParseException, IOException {
        JSONObject json = new JSONObject();

        json.put("al_t", this.al);
        json.put("k1_t", this.k1);
        json.put("k2_t", this.k2);
        json.put("acd_t", this.acd);
        json.put("lt_t", this.lt);
        json.put("cct_t", this.cct);
        json.put("k1_t_axis", this.k1_axis);
        json.put("k2_t_axis", this.k2_axis);
        json.put("sia", this.sia);
        json.put("inc", this.incision);

        return json;
    }

}
