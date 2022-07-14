package calc.eye.toric;

import org.json.JSONObject;

public class EyeToricValidator {

    private JSONObject errors;

    public EyeToricValidator() {
        this.errors = new JSONObject();
    }

    public JSONObject errors() {
        return this.errors;
    }

    public boolean isAlValid(String al) {
        boolean isValid;

        if(!al.equals("")) {
            isValid = 18 <= Float.parseFloat(al) && Float.parseFloat(al) <= 35;
            checkUpdateError(isValid, "al", al, "[18.0, 35.0]");
        }
        else {
            isValid = false;
            checkUpdateError(isValid, "al", "None", "[18.0, 35.0]");
        }

        return isValid;
    }

    public boolean isK1Valid(String k1) {
        boolean isValid;

        if(!k1.equals("")) {
            isValid = 30 <= Float.parseFloat(k1) && Float.parseFloat(k1) <= 65;
            checkUpdateError(isValid, "k1", k1, "[30.0, 65.0]");
        }
        else {
            isValid = false;
            checkUpdateError(isValid, "k1", "None", "[30.0, 65.0]");
        }

        return isValid;
    }

    public boolean isK2Valid(String k1, String k2) {
        boolean isValid;

        if(!k1.equals("") && !k2.equals("")) {
            isValid = (30 <= Float.parseFloat(k2) && Float.parseFloat(k2) <= 65) &&
                    (Float.parseFloat(k1) <= Float.parseFloat(k2));
            checkUpdateError(isValid, "k2", k2, "[30.0, 65.0] and must be k2 > k1");
        }
        else {
            isValid = false;
            checkUpdateError(isValid, "k2", "None", "[30.0, 65.0] and must be k2 > k1");
        }

        return isValid;
    }

    public boolean isAcdValid(String acd) {
        boolean isValid;

        if(!acd.equals("")) {
            isValid = 1.5 <= Float.parseFloat(acd) && Float.parseFloat(acd) <= 5;
            checkUpdateError(isValid, "acd", acd,"[1.5, 5.0]");
        }
        else {
            isValid = false;
            checkUpdateError(isValid, "acd", "None", "[1.5, 5.0]");
        }

        return isValid;
    }

    public boolean isLtValid(String lt) {
        boolean isValid = lt.equals("") || (2.5 <= Float.parseFloat(lt) && Float.parseFloat(lt) <= 8);

        checkUpdateError(isValid, "lt", lt,"[2.5, 8.0]");

        return isValid;
    }

    public boolean isCctValid(String cct) {
        boolean isValid = cct.equals("") || (350 <= Float.parseFloat(cct) && Float.parseFloat(cct) <= 650);

        checkUpdateError(isValid, "cct", cct, "[350.0, 650.0]");

        return isValid;
    }

    public boolean isSiaValid(String sia) {
        boolean isValid;

        if(!sia.equals("")) {
            isValid = (0 <= Float.parseFloat(sia) && Float.parseFloat(sia) <= 1);
            checkUpdateError(isValid, "sia", sia, "[0.0, 1.0]");
        }
        else {
            isValid = false;
            checkUpdateError(isValid, "sia", "None", "[0.0, 1.0]");
        }

        return isValid;
    }

    public boolean isIncisionValid(String incision) {
        boolean isValid;

        if(!incision.equals("")) {
            isValid = (0 <= Float.parseFloat(incision) && Float.parseFloat(incision) <= 360);
            checkUpdateError(isValid, "incision", incision, "[0.0, 360.0]");
        }
        else {
            isValid = false;
            checkUpdateError(isValid, "incision", "None", "[0.0, 360.0]");
        }

        return isValid;
    }

    public boolean isK1axisValid(String k1axis) {
        boolean isValid;

        if(!k1axis.equals("")) {
            isValid = (0 <= Float.parseFloat(k1axis) && Float.parseFloat(k1axis) <= 180);
            checkUpdateError(isValid, "k1_axis", k1axis, "[0.0, 180.0]");
        }
        else {
            isValid = false;
            checkUpdateError(isValid, "k1_axis", "None", "[0.0, 180.0]");
        }

        return isValid;
    }

    // TODO idk how it is calculated
//    public boolean isK2axisValid(String k2axis) {
//        return 0 <= Float.parseFloat(k1axis) && Float.parseFloat(k1axis) <= 180;
//    }

    private void checkUpdateError(Boolean isValid,
                                  String varName, String value, String correctValues) {
        if (!isValid) {
            this.errors.put(varName, value + " != " + correctValues);
        }
    }

}
