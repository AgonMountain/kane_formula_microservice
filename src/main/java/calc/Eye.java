package calc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.text.ParseException;

public class Eye {
    @JsonProperty("nontoric") private int isNonToric;
    @JsonProperty("toric") private int isToric;
    @JsonProperty("keratoconus") private int isKeratoconus;
    @JsonProperty("aconstant") private String constantA = "";
    @JsonProperty("ioltype") private String iolType = "";
    @JsonProperty("ioltype_str") private String iolTypeStr = "";
    @JsonProperty("sifitype") private int sifiType;
    @JsonProperty("target_ref") private String targetRefraction = "";
    @JsonProperty("al") private String al = "";
    @JsonProperty("k1") private String k1 = "";
    @JsonProperty("k2") private String k2 = "";
    @JsonProperty("acd") private String acd = "";
    @JsonProperty("lt") private String lt = "";
    @JsonProperty("cct") private String cct = "";
    @JsonProperty("al_t") private String al_t = "";
    @JsonProperty("k1_t") private String k1_t = "";
    @JsonProperty("k2_t") private String k2_t = "";
    @JsonProperty("acd_t") private String acd_t = "";
    @JsonProperty("lt_t") private String lt_t = "";
    @JsonProperty("cct_t") private String cct_t = "";
    @JsonProperty("k1_t_axis") private String k1_t_axis = "";
    @JsonProperty("k2_t_axis") private String k2_t_axis = "";
    @JsonProperty("sia") private String sia = "";
    @JsonProperty("inc") private String incision = "";
    @JsonProperty("is_set") private boolean isSet;
    @JsonProperty("is_valid") private boolean isValid;

    Eye(Boolean isNonToric, Boolean isKeratoconus, String constantA, String iolType, String iolTypeStr,
        int sifiType, String targetRefraction, String al, String k1, String k2,
        String acd, String lt, String cct, String incision, String sia) {

        this.isNonToric = isNonToric ? 1 : 0;
        this.isToric = isNonToric ? 0 : 1;
        this.isKeratoconus = isKeratoconus ? 1 : 0;
        this.constantA = constantA;
        this.iolType = iolType;
        this.iolTypeStr = iolTypeStr;
        this.sifiType = sifiType;
        this.targetRefraction = targetRefraction;
        this.al = this.al_t = al;
        this.k1 = this.k1_t = k1;
        this.k2 = this.k2_t =k2;
        this.acd = this.acd_t = acd;
        this.lt = this.lt_t = lt;
        this.cct = this.cct_t = cct;

        this.sia = sia;
        this.incision = incision;

        this.isSet = true;
        this.isValid = true;
    }

    Eye(Boolean isToric, Boolean isKeratoconus, String constantA, String iolType, String iolTypeStr,
        int sifiType, String targetRefraction, String al_t, String k1_t, String k1_t_axis, String k2_t, String k2_t_axis,
        String acd_t, String lt_t, String cct_t, String incision, String sia) {

        this.isNonToric = isToric ? 0 : 1;
        this.isToric = isToric ? 1 : 0;
        this.isKeratoconus = isKeratoconus ? 1 : 0;
        this.constantA = constantA;
        this.iolType = iolType;
        this.iolTypeStr = iolTypeStr;
        this.sifiType = sifiType;
        this.targetRefraction = targetRefraction;

        this.al = this.al_t = al_t;
        this.k1 = this.k1_t = k1_t;
        this.k2 = this.k2_t = k2_t;
        this.acd = this.acd_t = acd_t;
        this.lt = this.lt_t = lt_t;
        this.cct = this.cct_t = cct_t;
        this.k1_t_axis = k1_t_axis;
        this.k2_t_axis = k2_t_axis;

        this.sia = sia;
        this.incision = incision;

        this.isSet = true;
        this.isValid = true;
    }

    public String toJson() throws ParseException, IOException {
        return new ObjectMapper().writeValueAsString(this).replace("\"", "\\\"");
    }
}
