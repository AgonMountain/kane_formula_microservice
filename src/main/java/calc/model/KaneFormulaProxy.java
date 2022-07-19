package calc.model;

import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.text.ParseException;
import java.util.Collections;


public class KaneFormulaProxy {

    private String url;

    public KaneFormulaProxy() {
        url = "https://www.iolformula.com/api/";
    }

    public String request(KaneFormula kane) throws ParseException, IOException {

        // head
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // body
        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("action", "kfapi");
        map.add("__xr", "1");
        map.add("z", this.createKaneFormulaRequestBody(kane).toString());

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        ResponseEntity<String> response = new RestTemplate().postForEntity(this.url, request , String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }

    private JSONObject createKaneFormulaRequestBody(KaneFormula kane) throws ParseException, IOException {
        JSONObject json = new JSONObject();

        json.put("surgeon_name", kane.getSurgeonName());
        json.put("patient_name", kane.getPatientName());
        json.put("id", kane.getPatientId());
        json.put("kindex", kane.getKIndex());
        json.put("is_male", kane.isMale() ? 1 : 0);
        json.put("is_female", kane.isMale() ? 0 : 1);

        if(kane.getRightEye() != null) {
            json.put("eye1", kane.getRightEye().toJson());
        }
        if(kane.getLeftEye() != null) {
            json.put("eye2", kane.getLeftEye().toJson());
        }

        // ???? TODO
        String id2 = "03ANYolqto2fvNB6WRAiFToxyDBDurExGoSARTBVRTTzEMoxUT9CP7tcV8LZ2OhJsiX31b7QB2SfFfH4to1C-ng-GDUwZBHW-Bz-NHiaCEIMCh3zqW39wS8hUUGV6-mRZ2P5DE4u2Ow0ZgcZB4qer5UqQMMNJLsA7GcOueKv7VHyYH-QBYMcc-5KVEn7lURE2MjqmwwbppropsL407EJMyBvvDPEQ-6tIT5U4DZERWiXkmKB-g1RJ0BHJCHo3suVwv2zF2c0UHsNUFueliA4JwnCtZT3KhI5JOLKUQIXjqMGW4ZfS0gyXjMLDVIOd1llDWV27gIxs1VVkWUhtI_qmhzo_lBFF4i_nZLnda5gMBZ5ro8gpsETTUYWma1xyuFVeVVeCACrZn57zwPYJ6zrivOk30j-9WV6ZLhUmSZsPIR-zZG4Jkc9NIEqzgwRtvjtkRIw9yYTIqaGzv";
        json.put("id2", id2);
        // ???? TODO
        String id3 = "0.9828209174387013_670";
        json.put("id3", id3);
        // ???? TODO
        JSONObject com = new JSONObject();
        com.put("is_valid", true);
        // ???? TODO
        JSONObject eye1 = new JSONObject();
        eye1.put("is_valid", true);
        if(kane.getRightEye() != null && !kane.getRightEye().isToric()) {
            eye1.put("k1_t_axis", 1);
            eye1.put("sia", 1);
            eye1.put("inc", 1);
        }
        // ???? TODO
        JSONObject eye2 = new JSONObject();
        eye2.put("is_valid", true);
        if(kane.getLeftEye() != null && !kane.getLeftEye().isToric()) {
            eye2.put("k1_t_axis", 1);
            eye2.put("sia", 1);
            eye2.put("inc", 1);
        }
        // ???? TODO
        JSONObject v = new JSONObject();
        v.put("com", com);
        v.put("eye1", eye1);
        v.put("eye2", eye2);
        // ???? TODO
        json.put("v", id3);
        // ???? TODO
        JSONObject mx = new JSONObject();
        mx.put("mx", json.toString());
        mx.put("jx_action", "wh");    // ???? TODO

        return mx;
    }
}
