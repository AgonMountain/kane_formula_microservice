package calc;

import java.io.IOException;
import java.text.ParseException;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class KaneFormulaController {

    @GetMapping("/kane")
    String kane(@RequestBody KaneFormulaDto newKaneFormulaDto, HttpServletResponse response) throws ParseException, IOException {
        if(newKaneFormulaDto.isValid()) {
            response.setStatus(200);
            return new KaneFormula(newKaneFormulaDto.getSurgeonName(),
                                    newKaneFormulaDto.getPatientName(),
                                    newKaneFormulaDto.getPatientId(),
                                    newKaneFormulaDto.getKIndex(),
                                    newKaneFormulaDto.getIsMale(),
                                    newKaneFormulaDto.getRightEye(),
                                    newKaneFormulaDto.getLeftEye()).getResult();
        }
        else {
            response.setStatus(400);
            JSONObject json = new JSONObject();
            json.put("ErrorLogs", newKaneFormulaDto.errorLogs());
            json.put("ErrorMessagesRu", newKaneFormulaDto.errorMessagesRu());
            return json.toString();
        }
    }

}
