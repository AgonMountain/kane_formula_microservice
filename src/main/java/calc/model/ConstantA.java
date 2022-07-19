package calc.model;

import org.json.JSONObject;
import java.io.IOException;
import java.text.ParseException;


public class ConstantA {

    private String value;
    private String typeIndex;
    private String typeStr;
    private int sifiType;


    public ConstantA(String value, ConstantAType type) {
        switch (type) {
            case IOL_Type -> { create(value, type, "0", "IOL Type", 0); }
            case Alcon_SN60WF -> { create(value, type, "1", "Alcon SN60WF", 0); }
            case Alcon_SA60AT -> { create(value, type, "2", "Alcon SA60AT", 0); }
            case Alcon_MN60MA -> { create(value, type, "3", "Alcon MN60MA", 0); }
            case AMO_ZCB00 -> { create(value, type, "4", "AMO ZCB00", 0); }
            case AMO_AR40e -> { create(value, type, "5", "AMO AR40e", 0); }
            case Zeiss_409M -> { create(value, type, "6", "Zeiss 409M", 0); }
            case Alcon_SN6ATx -> { create(value, type, "7", "Alcon SN6ATx", 0); }
            case Alcon_SND1Tx -> { create(value, type, "8", "Alcon SND1Tx", 0); }
            case Alcon_SV25Tx -> { create(value, type, "9", "Alcon SV25Tx", 0); }
            case J_J_ZCTx -> { create(value, type, "10", "J+J ZCTx", 0); }
            case SIFI_Mini_Toric -> { create(value, type, "11", "SIFI Mini Toric", 1); }
            case SIFI_Mini_WELL_Toric -> { create(value, type, "12", "SIFI Mini WELL Toric", 2); }
            case HumanOptics_TORICA -> { create(value, type, "13", "HumanOptics TORICA", 3); }
            case Primus_HD_Toric -> { create(value, type, "14", "Primus-HD Toric", 4); }
        }
    }

    private void create(String value, ConstantAType type, String typeIndex, String typeStr, int sifiType) {
        this.value = value.equals("") ? getDefaultConstantTypeValue(type) : value;
        this.typeStr = typeStr;
        this.typeIndex = typeIndex;
        this.sifiType = sifiType;
    }

    public String getDefaultConstantTypeValue(ConstantAType type) {
        switch (type) {
            case IOL_Type -> { return "110"; } // min
            case Alcon_SN60WF -> { return "118.98"; }
            case Alcon_SA60AT -> { return "118.7"; }
            case Alcon_MN60MA -> { return "119.24"; }
            case AMO_ZCB00 -> { return "119.36"; }
            case AMO_AR40e -> { return "118.7"; }
            case Zeiss_409M -> { return "118.34"; }
            case Alcon_SN6ATx -> { return "119.28"; }
            case Alcon_SND1Tx -> { return "119.35"; }
            case Alcon_SV25Tx -> { return "119.49"; }
            case J_J_ZCTx -> { return "119.36"; }
            case SIFI_Mini_Toric -> { return "118.94"; }
            case SIFI_Mini_WELL_Toric -> { return "118.72"; }
            case HumanOptics_TORICA -> { return "118.3"; }
            case Primus_HD_Toric -> { return "119.2"; }
        }
        return "";
    }

    public JSONObject toJson() throws ParseException, IOException {
        JSONObject json = new JSONObject();

        json.put("aconstant", this.value);
        json.put("ioltype", this.typeIndex);
        json.put("ioltype_str", this.typeStr);
        json.put("sifitype", this.sifiType);

        return json;
    }

}
