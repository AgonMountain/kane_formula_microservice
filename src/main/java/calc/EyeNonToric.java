package calc;

import org.json.JSONObject;


import java.io.IOException;
import java.text.ParseException;


public class EyeNonToric {

    private String al;
    private String k1;
    private String k2;
    private String acd;
    private String lt;
    private String cct;

    EyeNonToric() {}

    EyeNonToric(String al, String k1, String k2, String acd, String lt, String cct) {
        this.al = al;
        this.k1 = k1;
        this.k2 = k2;
        this.acd = acd;
        this.lt = lt;
        this.cct = cct;
    }

    public JSONObject toJson() throws ParseException, IOException {
        JSONObject json = new JSONObject();

        json.put("al", this.al);
        json.put("k1", this.k1);
        json.put("k2", this.k2);
        json.put("acd", this.acd);
        json.put("lt", this.lt);
        json.put("cct", this.cct);

        return json;
    }
}
