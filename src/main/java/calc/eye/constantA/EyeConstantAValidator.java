package calc.eye.constantA;

import org.json.JSONObject;

public class EyeConstantAValidator {

    private JSONObject errors;

    public EyeConstantAValidator() {
        this.errors = new JSONObject();
    }

    public JSONObject errors() {
        return this.errors;
    }

    public boolean isConstantAValid(String constantA, String type) {
        Boolean isValid;

        if (!constantA.equals("")) {
            isValid = (110 <= Float.parseFloat(constantA) && Float.parseFloat(constantA) <= 125);
            checkUpdateError(isValid, "constant_a", constantA, "[110; 125]");
        }
        else if (!type.equals("")){
            isValid = isConstantTypeValid(type);
            checkUpdateError(isValid, "type", type,
                    "{IOL Type, Alcon SN60WF, Alcon SA60AT, Alcon MN60MA, AMO ZCB00, AMO AR40e" +
                            "Zeiss 409M, Alcon SN6ATx, Alcon SND1Tx, Alcon SV25Tx, J+J ZCTx, SIFI Mini Toric" +
                            "SIFI Mini WELL Toric, HumanOptics TORICA, Primus-HD Toric}");
        }
        else {
            isValid = false;
            checkUpdateError(isValid, "constant_a / type", "None", "[110; 125] or set Type" +
                    "{IOL Type, Alcon SN60WF, Alcon SA60AT, Alcon MN60MA, AMO ZCB00, AMO AR40e," +
                    "Zeiss 409M, Alcon SN6ATx, Alcon SND1Tx, Alcon SV25Tx, J+J ZCTx, SIFI Mini Toric," +
                    "SIFI Mini WELL Toric, HumanOptics TORICA, Primus-HD Toric}");
        }

        return isValid;
    }

    public Boolean isConstantTypeValid(String type) {
        switch (type) {
            case "IOL Type" -> { return true; }
            case "Alcon SN60WF" -> { return true; }
            case "Alcon SA60AT" -> { return true; }
            case "Alcon MN60MA" -> { return true; }
            case "AMO ZCB00" -> { return true; }
            case "AMO AR40e" -> { return true; }
            case "Zeiss 409M" -> { return true; }
            case "Alcon SN6ATx" -> { return true; }
            case "Alcon SND1Tx" -> { return true; }
            case "Alcon SV25Tx" -> { return true; }
            case "J+J ZCTx" -> { return true; }
            case "SIFI Mini Toric" -> { return true; }
            case "SIFI Mini WELL Toric" -> { return true; }
            case "HumanOptics TORICA" -> { return true; }
            case "Primus-HD Toric" -> { return true; }
        };
        return false;
    }

    private void checkUpdateError(Boolean isValid,
                                  String varName, String value, String correctValues) {
        if (!isValid) {
            this.errors.put(varName, value + " != " + correctValues);
        }
    }
}
