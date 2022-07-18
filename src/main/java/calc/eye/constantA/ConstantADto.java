package calc.eye.constantA;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.JSONObject;

public class ConstantADto {

    private @JsonProperty("value") String value;
    private @JsonProperty("type") String type;
    private ConstantAValidator validator;




    public ConstantADto(String value, String type) {
        this.value = value;
        this.type = type;

        this.validator = new ConstantAValidator();
    }

    public String getValue() {
        return this.value;
    }

    public ConstantAType getConstantType() {
        return this.fromStringToConstantType(this.type);
    }

    private ConstantAType fromStringToConstantType(String type){
        if (type != null) {
            switch (type) {
                case "IOL Type" -> { return ConstantAType.IOL_Type; }
                case "Alcon SN60WF" -> { return ConstantAType.Alcon_SN60WF; }
                case "Alcon SA60AT" -> { return ConstantAType.Alcon_SA60AT; }
                case "Alcon MN60MA" -> { return ConstantAType.Alcon_MN60MA; }
                case "AMO ZCB00" -> { return ConstantAType.AMO_ZCB00; }
                case "AMO AR40e" -> { return ConstantAType.AMO_AR40e; }
                case "Zeiss 409M" -> { return ConstantAType.Zeiss_409M; }
                case "Alcon SN6ATx" -> { return ConstantAType.Alcon_SN6ATx; }
                case "Alcon SND1Tx" -> { return ConstantAType.Alcon_SND1Tx; }
                case "Alcon SV25Tx" -> { return ConstantAType.Alcon_SV25Tx; }
                case "J+J ZCTx" -> { return ConstantAType.J_J_ZCTx; }
                case "SIFI Mini Toric" -> { return ConstantAType.SIFI_Mini_Toric; }
                case "SIFI Mini WELL Toric" -> { return ConstantAType.SIFI_Mini_WELL_Toric; }
                case "HumanOptics TORICA" -> { return ConstantAType.HumanOptics_TORICA; }
                case "Primus-HD Toric" -> { return ConstantAType.Primus_HD_Toric; }
            };
        }
        return null;
    }

    public boolean isValid() {
        Boolean isValid = this.validator.isConstantAValid(this.value, this.type);

        return isValid;
    }

    public JSONObject errorLogs() {
        return this.validator.getErrorLog();
    }

    public JSONObject errorMessagesRu() {
        return this.validator.getErrorMessageRu();
    }

}
