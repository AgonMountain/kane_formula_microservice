package calc.eye.constantA;

import org.json.JSONObject;

import java.io.IOException;
import java.text.ParseException;


public class EyeConstantA {

    private String constantA;
    private String iolType;
    private String iolTypeStr;
    private int sifiType;

    public EyeConstantA() {}

    public EyeConstantA(String constantA, ConstantA type) {

        switch (type) {
            case IOL_Type -> { create(constantA, type, "0", "IOL Type", 0); }
            case Alcon_SN60WF -> { create(constantA, type, "1", "Alcon SN60WF", 0); }
            case Alcon_SA60AT -> { create(constantA, type, "2", "Alcon SA60AT", 0); }
            case Alcon_MN60MA -> { create(constantA, type, "3", "Alcon MN60MA", 0); }
            case AMO_ZCB00 -> { create(constantA, type, "4", "AMO ZCB00", 0); }
            case AMO_AR40e -> { create(constantA, type, "5", "AMO AR40e", 0); }
            case Zeiss_409M -> { create(constantA, type, "6", "Zeiss 409M", 0); }
            case Alcon_SN6ATx -> { create(constantA, type, "7", "Alcon SN6ATx", 0); }
            case Alcon_SND1Tx -> { create(constantA, type, "8", "Alcon SND1Tx", 0); }
            case Alcon_SV25Tx -> { create(constantA, type, "9", "Alcon SV25Tx", 0); }
            case J_J_ZCTx -> { create(constantA, type, "10", "J+J ZCTx", 0); }
            case SIFI_Mini_Toric -> { create(constantA, type, "11", "SIFI Mini Toric", 1); }
            case SIFI_Mini_WELL_Toric -> { create(constantA, type, "12", "SIFI Mini WELL Toric", 2); }
            case HumanOptics_TORICA -> { create(constantA, type, "13", "HumanOptics TORICA", 3); }
            case Primus_HD_Toric -> { create(constantA, type, "14", "Primus-HD Toric", 4); }
        }
    }

    private void create(String constantA, ConstantA type, String iolType, String iolTypeStr, int sifiType) {
        this.constantA = constantAValue(constantA, type);
        this.iolTypeStr = iolTypeStr;
        this.iolType = iolType;
        this.sifiType = sifiType;
    }

    private String constantAValue(String constantA, ConstantA type) {
        return constantA.equals("") ? constantADefaultValue(type) : constantA;
    }

    static public String constantADefaultValue(ConstantA type) {
        switch (type) {
            case IOL_Type -> { return "110"; }
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

        json.put("aconstant", this.constantA);
        json.put("ioltype", this.iolType);
        json.put("ioltype_str", this.iolTypeStr);
        json.put("sifitype", this.sifiType);

        return json;
    }

}
