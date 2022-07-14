package calc.eye.constantA;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.JSONObject;

public class EyeConstantADto {

    private @JsonProperty("constant_a") String constantA;
    private @JsonProperty("type") String iolTypeStr;

    private JSONObject errors;

    public EyeConstantADto(String constantA, String iolTypeStr) {
        this.constantA = constantA;
        this.iolTypeStr = iolTypeStr;

        this.errors = new JSONObject();
    }

    public String getConstantA() {
        return this.constantA;
    }

    public ConstantA getConstantType() {
        switch (this.iolTypeStr) {
            case "IOL Type" -> { return ConstantA.IOL_Type; }
            case "Alcon SN60WF" -> { return ConstantA.Alcon_SN60WF; }
            case "Alcon SA60AT" -> { return ConstantA.Alcon_SA60AT; }
            case "Alcon MN60MA" -> { return ConstantA.Alcon_MN60MA; }
            case "AMO ZCB00" -> { return ConstantA.AMO_ZCB00; }
            case "AMO AR40e" -> { return ConstantA.AMO_AR40e; }
            case "Zeiss 409M" -> { return ConstantA.Zeiss_409M; }
            case "Alcon SN6ATx" -> { return ConstantA.Alcon_SN6ATx; }
            case "Alcon SND1Tx" -> { return ConstantA.Alcon_SND1Tx; }
            case "Alcon SV25Tx" -> { return ConstantA.Alcon_SV25Tx; }
            case "J+J ZCTx" -> { return ConstantA.J_J_ZCTx; }
            case "SIFI Mini Toric" -> { return ConstantA.SIFI_Mini_Toric; }
            case "SIFI Mini WELL Toric" -> { return ConstantA.SIFI_Mini_WELL_Toric; }
            case "HumanOptics TORICA" -> { return ConstantA.HumanOptics_TORICA; }
            case "Primus-HD Toric" -> { return ConstantA.Primus_HD_Toric; }
        };
        return null;
    }

    public boolean isValid() {
        EyeConstantAValidator validator = new EyeConstantAValidator();
        Boolean isValid = validator.isConstantAValid(this.constantA, this.iolTypeStr);
        isValid = validator.isConstantTypeValid(this.iolTypeStr) && isValid;

        this.errors = validator.errors();

        return isValid;
    }

    public JSONObject errors() {
        return this.errors;
    }

}
