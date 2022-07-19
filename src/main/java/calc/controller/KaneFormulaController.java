package calc.controller;

import java.io.IOException;
import java.text.ParseException;

import calc.model.KaneFormula;
import calc.model.dto.KaneFormulaDto;
import calc.model.KaneFormulaProxy;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class KaneFormulaController {

    @GetMapping("/kane")
    String kane(@RequestBody KaneFormulaDto newKaneFormulaDto, HttpServletResponse response) throws ParseException, IOException {
        if(newKaneFormulaDto.isValid()) {
            response.setStatus(200);    // http IS_OK
            KaneFormula kane = new KaneFormula(newKaneFormulaDto.getSurgeonName(),
                                                newKaneFormulaDto.getPatientName(),
                                                newKaneFormulaDto.getPatientId(),
                                                newKaneFormulaDto.getKIndex(),
                                                newKaneFormulaDto.getIsMale(),
                                                newKaneFormulaDto.getRightEye(),
                                                newKaneFormulaDto.getLeftEye());
            return new KaneFormulaProxy().request(kane);
        }
        else {
            response.setStatus(400);    // http IS_BAD
            JSONObject json = new JSONObject();
            json.put("ErrorLogs", newKaneFormulaDto.errorLogs());
            json.put("ErrorMessagesRu", newKaneFormulaDto.errorMessagesRu());
            return json.toString();
        }
    }

}
