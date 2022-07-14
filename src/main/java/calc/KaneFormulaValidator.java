package calc;

public class KaneFormulaValidator {

    public boolean isKindexValid(String kIndex) {
        return (kIndex.equals("1.3375") ||
                kIndex.equals("1.332") ||
                kIndex.equals("1.3315") ||
                kIndex.equals("1.3360") ||
                kIndex.equals("1.3380"));
    }

}
