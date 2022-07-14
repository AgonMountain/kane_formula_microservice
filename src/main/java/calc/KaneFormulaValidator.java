package calc;

import org.json.JSONObject;

public class KaneFormulaValidator {

    private JSONObject errors;

    public KaneFormulaValidator() {
        this.errors = new JSONObject();
    }

    public JSONObject errors() {
        return this.errors;
    }

    public boolean isKindexValid(String kIndex) {
        boolean isValid = (kIndex.equals("1.3375") ||
                kIndex.equals("1.332") ||
                kIndex.equals("1.3315") ||
                kIndex.equals("1.3360") ||
                kIndex.equals("1.3380"));;

        checkUpdateError(isValid, "k_index", kIndex, "{1.3375, 1.332, 1.3315, 1.3360, 1.3380}");

        return isValid;
    }

    private void checkUpdateError(Boolean isValid,
                                  String varName, String value, String correctValues) {
        if (!isValid) {
            this.errors.put(varName, value + " != " + correctValues);
        }
    }
}
