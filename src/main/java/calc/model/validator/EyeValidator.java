package calc.model.validator;

import calc.model.dto.ConstantADto;
import calc.model.dto.EyeNonToricDto;
import calc.model.dto.EyeToricDto;
import org.json.JSONObject;


public class EyeValidator {

    private JSONObject errorLog;
    private JSONObject errorMessageRu;


    public EyeValidator() {
        this.errorLog = new JSONObject();
        this.errorMessageRu = new JSONObject();
    }

    public JSONObject getErrorLog() {
        return this.errorLog;
    }

    public JSONObject getErrorMessageRu() {
        return this.errorMessageRu;
    }

    public boolean isTargetRefractionValid(String targetRefraction) {
        boolean isValid = false;

        if (targetRefraction == null) {
            updateErrorLog("target_refraction","Null","[-6.0, 2.0]");
            updateErrorMessageRu("target_refraction",
                    "не был получен. Значение параметра должно быть в диапазоне от -6.0 до 2.0 включительно");
        }
        else if (targetRefraction.equals("")) {
            updateErrorLog("target_refraction", "None", "[-6.0, 2.0]");
            updateErrorMessageRu("target_refraction",
                    "не содержит значение. Значение параметра должно быть в диапазоне от -6.0 до 2.0 включительно");
        }
        else {
            isValid = (-6 <= Float.parseFloat(targetRefraction) && Float.parseFloat(targetRefraction) <= 2);

            if(!isValid) {
                updateErrorLog("target_refraction", targetRefraction, "[-6.0, 2.0]");
                updateErrorMessageRu("target_refraction",
                        "задан некорректно. Значение параметра должно быть в диапазоне от -6.0 до 2.0 включительно");
            }
        }

        return isValid;
    }

    public boolean isNontoricEyeValid(EyeNonToricDto eyeNonToric) {
        boolean isValid = true;

        if (eyeNonToric != null && !eyeNonToric.isValid()) {
            this.errorLog.put("eye", eyeNonToric.errorLogs());
            this.errorMessageRu.put("eye", eyeNonToric.errorMessagesRu());
            isValid = false;
        }

        return isValid;
    }

    public boolean isToricEyeValid(EyeToricDto eyeToric) {
        boolean isValid = true;

        if (eyeToric != null && !eyeToric.isValid()) {
            this.errorLog.put("eye", eyeToric.errorLogs());
            this.errorMessageRu.put("eye", eyeToric.errorMessagesRu());
            isValid = false;
        }

        return isValid;
    }

    public boolean isEyeValid(EyeToricDto eyeToric, EyeNonToricDto eyeNonToric) {
        boolean isValid = true;

        // not set eye (toric / nontoric)
        if (eyeToric == null && eyeNonToric == null) {
            this.errorLog.put("eye", "Null");
            this.errorMessageRu.put("eye", "Параметр не был задан.");
            isValid = false;
        }

        return isValid;
    }

    public boolean isConstantAValid(ConstantADto constantA) {
        boolean isValid = true;

        if (constantA.errorLogs().length() != 0) {
            this.errorLog.put("constant_a", constantA.errorLogs());
            this.errorMessageRu.put("constant_a", constantA.errorMessagesRu());
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
