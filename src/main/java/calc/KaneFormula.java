package calc;

import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collections;
import java.util.Iterator;


public class KaneFormula {

    private String surgeonName;
    private String patientName;
    private String patientId;
    private String kIndex;
    private boolean isMale;
    private Eye rightEye;
    private Eye leftEye;

    private String result;

    KaneFormula() throws ParseException, IOException {

    }

    KaneFormula(String surgeonName,
                String patientName,
                String patientId,
                String kIndex,
                boolean isMale,
                Eye rightEye,
                Eye leftEye) throws ParseException, IOException {

        this.surgeonName = surgeonName;
        this.patientName = patientName;
        this.patientId = patientId;
        this.kIndex = kIndex;
        this.isMale = isMale;
        this.rightEye = rightEye;
        this.leftEye = leftEye;

        this.result = post();
    }

    public String getResult() {
        return this.result;
    }

    private String post() throws ParseException, IOException {

        String url = "https://www.iolformula.com/api/";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("action", "kfapi");
        map.add("__xr", "1");
        String p = this.createRequest().toString();
        map.add("z", this.createRequest().toString());

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        ResponseEntity<String> response = new RestTemplate().postForEntity( url, request , String.class );

        // check response status code
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }

    private JSONObject createRequest() throws ParseException, IOException {

        JSONObject json = new JSONObject();

        json.put("surgeon_name", this.surgeonName);
        json.put("patient_name", this.patientName);
        json.put("id", this.patientId);
        json.put("kindex", this.kIndex);
        json.put("is_male", this.isMale ? 1 : 0);
        json.put("is_female", this.isMale ? 0 : 1);

        if(this.rightEye != null) {
            json.put("eye1", this.rightEye.toJson());
        }
        if(this.leftEye != null) {
            json.put("eye2", this.leftEye.toJson());
        }

        // ????
        String id2 = "03ANYolqto2fvNB6WRAiFToxyDBDurExGoSARTBVRTTzEMoxUT9CP7tcV8LZ2OhJsiX31b7QB2SfFfH4to1C-ng-GDUwZBHW-Bz-NHiaCEIMCh3zqW39wS8hUUGV6-mRZ2P5DE4u2Ow0ZgcZB4qer5UqQMMNJLsA7GcOueKv7VHyYH-QBYMcc-5KVEn7lURE2MjqmwwbppropsL407EJMyBvvDPEQ-6tIT5U4DZERWiXkmKB-g1RJ0BHJCHo3suVwv2zF2c0UHsNUFueliA4JwnCtZT3KhI5JOLKUQIXjqMGW4ZfS0gyXjMLDVIOd1llDWV27gIxs1VVkWUhtI_qmhzo_lBFF4i_nZLnda5gMBZ5ro8gpsETTUYWma1xyuFVeVVeCACrZn57zwPYJ6zrivOk30j-9WV6ZLhUmSZsPIR-zZG4Jkc9NIEqzgwRtvjtkRIw9yYTIqaGzv";
        json.put("id2", id2);
        // ????
        String id3 = "0.9828209174387013_670";
        json.put("id3", id3);
        // ????
        JSONObject com = new JSONObject();
        com.put("is_valid", true);
        // ????
        JSONObject rightEye = new JSONObject();
        com.put("is_valid", true);
        // ????
        JSONObject leftEye = new JSONObject();
        com.put("is_valid", true);
        com.put("k1_t_axis", 1);
        com.put("sia", 1);
        com.put("inc", 1);
        // ????
        JSONObject v = new JSONObject();
        v.put("com", com);
        v.put("eye1", rightEye);
        v.put("eye2", leftEye);
        // ????
        json.put("v", id3);
        // ????
        JSONObject mx = new JSONObject();
        mx.put("mx", json.toString());
        mx.put("jx_action", "wh");    // ????

        return mx;
    }

    private JSONObject embed(JSONObject main, JSONObject embedded) {
        JSONObject newJson = new JSONObject(main, JSONObject.getNames(main));
        Iterator<String> key = embedded.keys();
        while (key.hasNext()) {
            String k = key.next();
            newJson.put(k, embedded.get(k));
        }
        return newJson;
    }
}
