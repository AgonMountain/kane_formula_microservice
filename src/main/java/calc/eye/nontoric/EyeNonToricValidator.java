package calc.eye.nontoric;

import org.json.JSONObject;

public class EyeNonToricValidator {

    private JSONObject errors;

    public EyeNonToricValidator() {
        this.errors = new JSONObject();
    }

    public JSONObject errors() {
        return this.errors;
    }

    public boolean isAlValid(String al) {
        boolean isValid = 18 <= Float.parseFloat(al) && Float.parseFloat(al) <= 35;

        checkUpdateError(isValid, "al", al, "[18.0, 35.0]");

        return isValid;
    }

    public boolean isK1Valid(String k1) {
        boolean isValid = 30 <= Float.parseFloat(k1) && Float.parseFloat(k1) <= 65;

        checkUpdateError(isValid, "k1", k1, "[30.0, 65.0]");

        return isValid;
    }

    public boolean isK2Valid(String k1, String k2) {
        boolean isValid = (30 <= Float.parseFloat(k2) && Float.parseFloat(k2) <= 65) &&
                (Float.parseFloat(k1) <= Float.parseFloat(k2));

        checkUpdateError(isValid, "k2", k2, "[30.0, 65.0] and must be k2 > k1");

        return isValid;
    }

    public boolean isAcdValid(String acd) {
        boolean isValid = 1.5 <= Float.parseFloat(acd) && Float.parseFloat(acd) <= 5;

        checkUpdateError(isValid, "acd", acd,"[1.5, 5.0]");

        return isValid;
    }

    public boolean isLtValid(String lt) {
        boolean isValid = 2.5 <= Float.parseFloat(lt) && Float.parseFloat(lt) <= 8;

        checkUpdateError(isValid, "lt", lt,"[2.5, 8.0]");

        return isValid;
    }

    public boolean isCctValid(String cct) {
        boolean isValid = 350 <= Float.parseFloat(cct) && Float.parseFloat(cct) <= 650;

        checkUpdateError(isValid, "cct", cct, "[350.0, 650.0]");

        return isValid;
    }

    private void checkUpdateError(Boolean isValid,
                                  String varName, String value, String correctValues) {
        if (!isValid) {
            this.errors.put(varName, value + " != " + correctValues);
        }
    }

}
