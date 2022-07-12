package calc;

import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Collections;
import java.util.Map;

public class KaneFormula {

    private @Id @GeneratedValue long id;
    private String surgeon;
    private String patientName;
    private String patientId;
    private String index;
    private boolean isMale;
    private Eye rightEye;
    private Eye leftEye;

    KaneFormula() {
        post();
    }

    KaneFormula(String surgeon,
                String patientName,
                String patientId,
                String index,
                boolean isMale,
                Eye rightEye,
                Eye leftEye) {

        this.surgeon = surgeon;
        this.patientName = patientName;
        this.patientId = patientId;
        this.index = index;
        this.isMale = isMale;
        this.rightEye = rightEye;
        this.leftEye = leftEye;
    }

    public String post() {
        String url = "https://www.iolformula.com/api/";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("action", "kfapi");
        map.add("__xr", "1");

        this.index = "1.3375";
        String z = "{\"mx\":\"{\\\"surgeon_name\\\":\\\"" + this.surgeon + "\\\"" +
                ",\\\"patient_name\\\":\\\"" + this.patientName + "\\\"" +
                ",\\\"id\\\":\\\"" + this.patientId + "\\\"" +
                ",\\\"kindex\\\":\\\"" + this.index + "\\\"" +
                ",\\\"is_male\\\":" + Integer.toString(this.isMale ? 1 : 0) +
                ",\\\"is_female\\\":" + Integer.toString(this.isMale ? 0 : 1) +
                ",\\\"eye1\\\":" +
                    "{\\\"nontoric\\\"" + Integer.toString(this.rightEye.getIsToric() ? 0 : 1) +
                    ",\\\"toric\\\":" + Integer.toString(this.rightEye.getIsToric() ? 1 : 0) +
                    ",\\\"keratoconus\\\":" + Integer.toString(this.rightEye.getIsKeratoconus() ? 1 : 0) +
                    ",\\\"aconstant\\\":\\\"" + this.rightEye.getConstantA() + "\\\"" +
                    ",\\\"ioltype\\\":\\\"" + "0" + "\\\"" +                                                // TODO
                    ",\\\"ioltype_str\\\":\\\"" + "" + "\\\"" +                                                 // TODO
                    ",\\\"sifitype\\\":" + "0" + "\\\"" +               // TODO
                    ",\\\"target_ref\\\":\\\"" + this.rightEye.getTargetRefraction() + "\\\"" +
                    ",\\\"al\\\":\\\"" + this.rightEye.getAl() + "\\\""


                ;


        map.add("z", z+",\\\"eye1\\\":{\\\"nontoric\\\":1,\\\"toric\\\":0,\\\"keratoconus\\\":1,\\\"aconstant\\\":\\\"110.5\\\",\\\"ioltype\\\":\\\"0\\\",\\\"ioltype_str\\\":\\\"\\\",\\\"sifitype\\\":0,\\\"target_ref\\\":\\\"-4\\\",\\\"al\\\":\\\"27\\\",\\\"k1\\\":\\\"39\\\",\\\"k2\\\":\\\"40\\\",\\\"acd\\\":\\\"4.22\\\",\\\"lt\\\":\\\"\\\",\\\"cct\\\":\\\"\\\",\\\"al_t\\\":\\\"27\\\",\\\"k1_t\\\":\\\"39\\\",\\\"k2_t\\\":\\\"40\\\",\\\"acd_t\\\":\\\"4.22\\\",\\\"lt_t\\\":\\\"\\\",\\\"cct_t\\\":\\\"\\\",\\\"k1_t_axis\\\":\\\"\\\",\\\"k2_t_axis\\\":\\\"\\\",\\\"sia\\\":\\\"\\\",\\\"inc\\\":\\\"\\\",\\\"is_set\\\":true,\\\"is_valid\\\":true},\\\"eye2\\\":{\\\"nontoric\\\":1,\\\"toric\\\":0,\\\"keratoconus\\\":0,\\\"aconstant\\\":\\\"119\\\",\\\"ioltype\\\":\\\"0\\\",\\\"ioltype_str\\\":\\\"\\\",\\\"sifitype\\\":0,\\\"target_ref\\\":\\\"-4\\\",\\\"al\\\":\\\"25\\\",\\\"k1\\\":\\\"34\\\",\\\"k2\\\":\\\"60\\\",\\\"acd\\\":\\\"1.9\\\",\\\"lt\\\":\\\"7.2\\\",\\\"cct\\\":\\\"410\\\",\\\"al_t\\\":\\\"25\\\",\\\"k1_t\\\":\\\"34\\\",\\\"k2_t\\\":\\\"60\\\",\\\"acd_t\\\":\\\"1.9\\\",\\\"lt_t\\\":\\\"7.2\\\",\\\"cct_t\\\":\\\"410\\\",\\\"k1_t_axis\\\":\\\"\\\",\\\"k2_t_axis\\\":\\\"\\\",\\\"sia\\\":\\\"\\\",\\\"inc\\\":\\\"\\\",\\\"is_set\\\":true,\\\"is_valid\\\":true},\\\"id2\\\":\\\"03ANYolqvO8O2l8sNC-g0yBbYOddhL9-HusLlXX44jWpU3iape5io4xq9NriX83WD2xtzhtpMc2LiQtinrlDtWiWaC9Yx1SGp_0Jkw2frCjkyDWgyPfg7ToudDnN1pC3bmBPx8-i1X1mXW-lEW8cu1YvOLEGNgMpVxJNFXNEpjTP_cuKsvUBfteSV2MTu_45NdXhMkeN_fX_cpNigMoC0DsddhztxB-1xwdbyeqACBC18XtO21j_v614c9mSLykDvbkNuxjheQGFpIIEH-KIZcwDE3iDHCuK7iB6a3dpKmXoyVWiKB1bHy3IGx6lnZW0hN1JysRR5YMwOr9OOsw_mfiJQP4_xVkYE0Ab16Q7MuU6H19H-r4aCRnJm3KRrLO-S67UMlX8MJ1ZdZdWZK6JBic5rT_GWWBDtn8k7IdCgi_ghpgrDdjYhyI4VqNNjzw_nb-OfTo0nHJMj_\\\",\\\"id3\\\":\\\"0.9828209174387013_670\\\",\\\"v\\\":{\\\"com\\\":{\\\"is_valid\\\":true},\\\"eye1\\\":{\\\"k1_t_axis\\\":1,\\\"sia\\\":1,\\\"inc\\\":1,\\\"is_valid\\\":true},\\\"eye2\\\":{\\\"k1_t_axis\\\":1,\\\"sia\\\":1,\\\"inc\\\":1,\\\"is_valid\\\":true}}}\",\"jx_action\":\"wh\"}");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        ResponseEntity<String> response = new RestTemplate().postForEntity( url, request , String.class );

        // check response status code
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }

}
