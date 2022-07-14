package calc;

public class EyeValidator {

    public boolean isTargetRefractionValid(String targetRefraction) {
        if (!targetRefraction.equals("")) {
            return (-6 <= Float.parseFloat(targetRefraction) && Float.parseFloat(targetRefraction) <= 2);
        }
        return true;
    }

}
