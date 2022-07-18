package calc.eye.nontoric;

import org.json.JSONObject;

public class EyeNonToricValidator {

    private JSONObject errorLog;
    private JSONObject errorMessageRu;




    public EyeNonToricValidator() {
        this.errorLog = new JSONObject();
        this.errorMessageRu = new JSONObject();
    }

    public JSONObject getErrorLog() {
        return this.errorLog;
    }

    public JSONObject getErrorMessageRu() {
        return this.errorMessageRu;
    }

    public boolean isAlValid(String al) {
        boolean isValid = false;

        if (al == null) {
            updateErrorLog("al","Null","[18.0, 35.0]");
            updateErrorMessageRu("al",
                    "не был получен. Значение параметра должно быть в диапазоне от 18.0 до 35.0 включительно");
        }
        else if (al.equals("")) {
            updateErrorLog("al", "None", "[18.0, 35.0]");
            updateErrorMessageRu("al",
                    "не содержит значение. Значение параметра должно быть в диапазоне от 18.0 до 35.0 включительно");
        }
        else {
            isValid = (18 <= Float.parseFloat(al) && Float.parseFloat(al) <= 35);

            if(!isValid) {
                updateErrorLog("al", al, "[18.0, 35.0]");
                updateErrorMessageRu("al",
                        "задан некорректно. Значение параметра должно быть в диапазоне от 18.0 до 35.0 включительно");
            }
        }

        return isValid;
    }

    public boolean isK1Valid(String k1) {
        boolean isValid = false;

        if (k1 == null) {
            updateErrorLog("k1","Null","[30.0, 65.0]");
            updateErrorMessageRu("k1",
                    "не был получен. Значение параметра должно быть в диапазоне от 30.0 до 65.0 включительно");
        }
        else if (k1.equals("")) {
            updateErrorLog("k1", "None", "[30.0, 65.0]");
            updateErrorMessageRu("k1",
                    "не содержит значение. Значение параметра должно быть в диапазоне от 30.0 до 65.0 включительно");
        }
        else {
            isValid = (30 <= Float.parseFloat(k1) && Float.parseFloat(k1) <= 65);

            if(!isValid) {
                updateErrorLog("k1", k1, "[30.0, 65.0]");
                updateErrorMessageRu("k1",
                        "задан некорректно. Значение параметра должно быть в диапазоне от 30.0 до 65.0 включительно");
            }
        }

        return isValid;
    }

    public boolean isK2Valid(String k1, String k2) {
        boolean isValid = false;

        if (k2 == null) {
            updateErrorLog("k2","Null","[30.0, 65.0] and must be k2 > k1");
            updateErrorMessageRu("k2",
                    "не был получен. Значение параметра должно быть в диапазоне от 30.0 до 65.0 включительно");
        }
        else if (k2.equals("")) {
            updateErrorLog("k2", "None", "[30.0, 65.0] and must be k2 > k1");
            updateErrorMessageRu("k2",
                    "не содержит значение. Значение параметра должно быть в диапазоне от 30.0 до 65.0 включительно");
        }
        else if (!k1.equals("")){
            isValid = (30 <= Float.parseFloat(k2) && Float.parseFloat(k2) <= 65) &&
                    (Float.parseFloat(k1) <= Float.parseFloat(k2));

            if(!isValid) {
                updateErrorLog("k2", k2, "[30.0, 65.0] and must be k2 > k1");
                updateErrorMessageRu("k2",
                        "задан некорректно. Значение параметра должно быть в диапазоне от 30.0 до 65.0 включительно," +
                                " и его значение должно быть больше Параметра k1");
            }
        }

        return isValid;
    }

    public boolean isAcdValid(String acd) {
        boolean isValid = false;

        if (acd == null) {
            updateErrorLog("acd","Null","[1.5, 5.0]");
            updateErrorMessageRu("acd",
                    "не был получен. Значение параметра должно быть в диапазоне от 1.5 до 5.0 включительно");
        }
        else if (acd.equals("")) {
            updateErrorLog("acd", "None", "[1.5, 5.0]");
            updateErrorMessageRu("acd",
                    "не содержит значение. Значение параметра должно быть в диапазоне от 1.5 до 5.0 включительно");
        }
        else {
            isValid = (1.5 <= Float.parseFloat(acd) && Float.parseFloat(acd) <= 5);

            if(!isValid) {
                updateErrorLog("acd", acd, "[1.5, 5.0]");
                updateErrorMessageRu("acd",
                        "задан некорректно. Значение параметра должно быть в диапазоне от 1.5 до 5.0 включительно");
            }
        }

        return isValid;
    }

    public boolean isLtValid(String lt) {
        boolean isValid = false;

        if (lt == null) {
            updateErrorLog("lt","Null","[2.5, 8.0]");
            updateErrorMessageRu("lt",
                    "не был получен. Значение параметра должно быть в диапазоне от 2.5 до 8.0 включительно");
        }
        else if (lt.equals("")) {
            isValid = true;
        }
        else {
            isValid = (2.5 <= Float.parseFloat(lt) && Float.parseFloat(lt) <= 8);

            if(!isValid) {
                updateErrorLog("lt", lt, "[2.5, 8.0]");
                updateErrorMessageRu("lt",
                        "задан некорректно. Значение параметра должно быть в диапазоне от 2.5 до 8.0 включительно");
            }
        }

        return isValid;
    }

    public boolean isCctValid(String cct) {
        boolean isValid = false;

        if (cct == null) {
            updateErrorLog("cct","Null","[350.0, 650.0]");
            updateErrorMessageRu("cct",
                    "не был получен. Значение параметра должно быть в диапазоне от 350.0 до 650.0 включительно");
        }
        else if (cct.equals("")) {
            isValid = true;
        }
        else {
            isValid = (350 <= Float.parseFloat(cct) && Float.parseFloat(cct) <= 650);

            if(!isValid) {
                updateErrorLog("cct", cct, "[350.0, 650.0]");
                updateErrorMessageRu("cct",
                        "задан некорректно. Значение параметра должно быть в диапазоне от 350.0 до 650.0 включительно");
            }
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
