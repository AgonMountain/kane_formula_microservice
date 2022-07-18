package calc.eye.constantA;

import org.json.JSONObject;

public class ConstantAValidator {

    private JSONObject errorLog;
    private JSONObject errorMessageRu;




    public ConstantAValidator() {
        this.errorLog = new JSONObject();
        this.errorMessageRu = new JSONObject();
    }

    public JSONObject getErrorLog() {
        return this.errorLog;
    }

    public JSONObject getErrorMessageRu() {
        return this.errorMessageRu;
    }

    public boolean isConstantAValid(String value, String type) {
        boolean isValid = false;

        if (value == null && type == null) {
            updateErrorLog("value","Null","[110.0; 125.0]");
            updateErrorMessageRu("value",
                    "не был получен. Значение параметра должно быть в диапазоне от 110.0 до 125.0 включительно." +
                            " Или укажите тип константы и будет применено значение константы по умолчанию для данного типа.");
        }
        else if (value != null && value.equals("") && type == null) {
            updateErrorLog("value","None","[110.0; 125.0]");
            updateErrorMessageRu("value",
                    "не содержит значение. Значение параметра должно быть в диапазоне от 110.0 до 125.0 включительно." +
                            " Или укажите тип константы и будет применено значение константы по умолчанию для данного типа.");
        }
        else if (value != null && !value.equals("")) {
            isValid = (110 <= Float.parseFloat(value) && Float.parseFloat(value) <= 125);

            if (!isValid) {
                updateErrorLog("value", value, "[110.0; 125.0]");
                updateErrorMessageRu("value",
                        "задан некорректно. Значение параметра должно быть в диапазоне от 110.0 до 125.0 включительно");
            }
        }
        else if (type != null && !type.equals("")) {
            isValid = isConstantTypeValid(type);
            if (!isValid) {
                updateErrorLog("type","None",
                        "IOL Type, Alcon SN60WF, Alcon SA60AT, Alcon MN60MA, AMO ZCB00, AMO AR40e," +
                        " Zeiss 409M, Alcon SN6ATx, Alcon SND1Tx, Alcon SV25Tx, J+J ZCTx, SIFI Mini Toric," +
                        " SIFI Mini WELL Toric, HumanOptics TORICA, Primus-HD Toric");
                updateErrorMessageRu("type",
                        "задан некорректно. Значение параметра должно быть одним из следующего списка:" +
                                " IOL Type, Alcon SN60WF, Alcon SA60AT, Alcon MN60MA, AMO ZCB00, AMO AR40e," +
                                " Zeiss 409M, Alcon SN6ATx, Alcon SND1Tx, Alcon SV25Tx, J+J ZCTx, SIFI Mini Toricn," +
                                " SIFI Mini WELL Toric, HumanOptics TORICA, Primus-HD Toric");
            }
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

    private void updateErrorLog(String varName, String value, String correctValues) {
        this.errorLog.put(varName, value + " != " + correctValues);
    }

    private void updateErrorMessageRu(String varName, String messageRu) {
        this.errorMessageRu.put(varName, "Параметр \"" + varName + "\" " + messageRu);
    }

}
