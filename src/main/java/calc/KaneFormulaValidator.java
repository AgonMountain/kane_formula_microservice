package calc;

import calc.eye.EyeDto;
import org.json.JSONObject;


public class KaneFormulaValidator {

    private JSONObject errorLog;
    private JSONObject errorMessageRu;




    public KaneFormulaValidator() {
        this.errorLog = new JSONObject();
        this.errorMessageRu = new JSONObject();
    }

    public JSONObject getErrorLog() {
        return this.errorLog;
    }

    public JSONObject getErrorMessageRu() {
        return this.errorMessageRu;
    }

    public boolean isKindexValid(String kIndex) {
        boolean isValid = false;

        if (kIndex == null) {
            updateErrorLog("k_index","Null","{1.3375, 1.332, 1.3315, 1.3360, 1.3380}");
            updateErrorMessageRu("k_index",
                    "не был получен. Значение параметра должно быть одним из следующего списка:" +
                            " {1.3375, 1.332, 1.3315, 1.3360, 1.3380}");
        }
        else if (kIndex.equals("")) {
            updateErrorLog("k_index","None","{1.3375, 1.332, 1.3315, 1.3360, 1.3380}");
            updateErrorMessageRu("k_index",
                    "не содержит значение. Значение параметра должно быть одним из следующего списка:" +
                            " {1.3375, 1.332, 1.3315, 1.3360, 1.3380}");
        }
        else {
            isValid = (kIndex.equals("1.3375") || kIndex.equals("1.332") || kIndex.equals("1.3315") ||
                    kIndex.equals("1.3360") || kIndex.equals("1.3380"));

            if(!isValid) {
                updateErrorLog("k_index",kIndex,"{1.3375, 1.332, 1.3315, 1.3360, 1.3380}");
                updateErrorMessageRu("k_index",
                        "задан некорректно. Значение параметра должно быть одним из следующего списка:" +
                                " {1.3375, 1.332, 1.3315, 1.3360, 1.3380}");
            }
        }

        return isValid;
    }

    public boolean isLeftEyeValid(EyeDto leftEye) {
        boolean isValid = true;

        if (leftEye.errorLogs().length() != 0) {
            this.errorLog.put("left_eye", leftEye.errorLogs());
            this.errorMessageRu.put("left_eye", leftEye.errorMessagesRu());
            isValid = false;
        }

        return isValid;
    }

    public boolean isRightEyeValid(EyeDto rightEye) {
        boolean isValid = true;

        if (rightEye.errorLogs().length() != 0) {
            this.errorLog.put("right_eye", rightEye.errorLogs());
            this.errorMessageRu.put("right_eye", rightEye.errorMessagesRu());
            isValid = false;
        }

        return isValid;
    }

    private void updateErrorLog(String varName, String value, String correctValues) {
        this.errorLog.put(varName, value + " != " + correctValues);
    }

    private void updateErrorMessageRu(String varName, String messageRu) {
        this.errorMessageRu.put(varName, "Параметр \"" + varName + "\" " + messageRu);
    }

}
