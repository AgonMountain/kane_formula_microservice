package calc;

import java.io.IOException;
import java.text.ParseException;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class KaneFormulaController {


    public KaneFormulaController() { }

    @PostMapping("/kane")
    String kane(@RequestBody KaneFormulaDto newKaneFormulaDto, HttpServletResponse response) throws ParseException, IOException {
        if(newKaneFormulaDto.isValid()) {
            response.setStatus(200);
            return new KaneFormula(newKaneFormulaDto.getSurgeonName(),
                    newKaneFormulaDto.getPatientName(),
                    newKaneFormulaDto.getPatientId(),
                    newKaneFormulaDto.getKIndex(),
                    newKaneFormulaDto.getIsMale(),
                    newKaneFormulaDto.getRightEye(),
                    newKaneFormulaDto.getLeftEye()).getResult(); // return result of request
        }
        else {
            response.setStatus(418);
            return new JSONObject().put("Errors", newKaneFormulaDto.errors()).toString();
        }
    }

}
