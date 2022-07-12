package calc;

public class CalculationNotFoundException extends RuntimeException {

    CalculationNotFoundException(Long id) {
        super("Could not find Calculation " + id);
    }

}
