package calc;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.web.bind.annotation.*;

@RestController
public class KaneFormulaController {


    KaneFormulaController() { }

    @PostMapping("/kane")
    String kane(@RequestBody KaneFormulaDto newKaneFormulaDto) throws ParseException, IOException {
        return new KaneFormula(newKaneFormulaDto.getSurgeonName(),
                                newKaneFormulaDto.getPatientName(),
                                newKaneFormulaDto.getPatientId(),
                                newKaneFormulaDto.getKIndex(),
                                newKaneFormulaDto.getIsMale(),
                                newKaneFormulaDto.getRightEye(),
                                newKaneFormulaDto.getLeftEye()).getResult(); // return result of request
    }

}
