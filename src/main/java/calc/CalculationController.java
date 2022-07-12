package calc;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class CalculationController {

    private final CalculationRepository repository;

    CalculationController(CalculationRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/calcs")
    List<Calculation> all(){
        return repository.findAll();
    }


    @PostMapping("/calcs")
    Calculation newCalculation(@RequestBody CalculationDto newCalculationDto) {
        return repository.save(new Calculation(newCalculationDto));
    }

    @GetMapping("/calcs/{id}")
    Calculation one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CalculationNotFoundException(id));
    }


    @PostMapping("/kane")
    Calculation kane(@RequestBody CalculationDto newCalculationDto) {
        new KaneFormula().post();
        return null;
    }
}
