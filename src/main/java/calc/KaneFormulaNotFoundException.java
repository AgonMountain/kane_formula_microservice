package calc;

public class KaneFormulaNotFoundException extends RuntimeException {

    KaneFormulaNotFoundException(Long id) {
        super("Could not find result " + id);
    }
}
