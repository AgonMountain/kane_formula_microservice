package calc.model.validator;

import calc.model.dto.EyeDto;
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

    public boolean isSurgeonNameValid(String surgeonName) {
        boolean isValid = false;

        if (surgeonName == null) {
            updateErrorLog("surgeon_name","Null","????");
            updateErrorMessageRu("surgeon_name", "не был получен.");
        }
        else if (surgeonName.equals("")) {
            isValid = true;
        }
        else {
            isValid = true; // TODO valid?

            if(!isValid) {
                updateErrorLog("surgeon_name",surgeonName,"????");
                updateErrorMessageRu("surgeon_name", "задан некорректно.");
            }
        }

        return isValid;
    }

    public boolean isPatientNameValid(String patientName) {
        boolean isValid = false;

        if (patientName == null) {
            updateErrorLog("patient_name","Null","????");
            updateErrorMessageRu("patient_name", "не был получен.");
        }
        else if (patientName.equals("")) {
            isValid = true;
        }
        else {
            isValid = true; // TODO valid?

            if(!isValid) {
                updateErrorLog("patient_name",patientName,"????");
                updateErrorMessageRu("patient_name", "задан некорректно.");
            }
        }

        return isValid;
    }

    public boolean isPatientIdValid(String patientId) {
        boolean isValid = false;

        if (patientId == null) {
            updateErrorLog("patient_id","Null","????");
            updateErrorMessageRu("patient_id", "не был получен.");
        }
        else if (patientId.equals("")) {
            isValid = true;
        }
        else {
            isValid = true; // TODO valid?

            if(!isValid) {
                updateErrorLog("patient_id",patientId,"????");
                updateErrorMessageRu("patient_id", "задан некорректно.");
            }
        }

        return isValid;
    }

    public boolean isVarIsMaleValid(Boolean isMale) {
        boolean isValid = true;

        if (isMale == null) {
            updateErrorLog("is_male","Null","true, false");
            updateErrorMessageRu("is_male", "не был получен. Значение параметра должно быть ДА или НЕТ.");
            isValid = false;
        }

        return isValid;
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

        if (leftEye != null && !leftEye.isValid()) {
            this.errorLog.put("left_eye", leftEye.errorLogs());
            this.errorMessageRu.put("left_eye", leftEye.errorMessagesRu());
            isValid = false;
        }

        return isValid;
    }

    public boolean isRightEyeValid(EyeDto rightEye) {
        boolean isValid = true;

        if (rightEye != null && !rightEye.isValid()) {
            this.errorLog.put("right_eye", rightEye.errorLogs());
            this.errorMessageRu.put("right_eye", rightEye.errorMessagesRu());
            isValid = false;
        }

        return isValid;
    }

    public boolean isOneOfEyesSet(EyeDto rightEye, EyeDto leftEye) {
        boolean isValid = true;

        if (leftEye == null && rightEye == null) {
            this.errorLog.put("right_eye", "Null");
            this.errorMessageRu.put("right_eye", "Параметр \"right_eye\" не был получен.");

            this.errorLog.put("left_eye", "Null");
            this.errorMessageRu.put("left_eye", "Параметр \"left_eye\" не был получен.");

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
