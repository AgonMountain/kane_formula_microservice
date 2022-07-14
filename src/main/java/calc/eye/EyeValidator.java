package calc.eye;

import org.json.JSONObject;

public class EyeValidator {

    private JSONObject errors;

    public EyeValidator() {
        this.errors = new JSONObject();
    }

    public JSONObject errors() {
        return this.errors;
    }

    public boolean isTargetRefractionValid(String targetRefraction) {
        boolean isValid = true;

        if (!targetRefraction.equals("")) {
            isValid = (-6 <= Float.parseFloat(targetRefraction) && Float.parseFloat(targetRefraction) <= 2);
        }

        if (!isValid) {
            checkUpdateError(isValid, "target_refraction", targetRefraction, "[-6.0, 2.0]");
        }

        return isValid;
    }

    private void checkUpdateError(Boolean isValid,
                                  String varName, String value, String correctValues) {
        if (!isValid) {
            this.errors.put(varName, value + " != " + correctValues);
        }
    }

}
