package calc;

import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;

import org.json.JSONObject;


public class Eye {

    private int isKeratoconus;
    private String targetRefraction;
    private EyeConstantA constantA;
    private EyeToric eyeToric;
    private EyeNonToric eyeNonToric;

    Eye() {}

    Eye(EyeToric eyeToric, EyeConstantA constantA, Boolean isKeratoconus, String targetRefraction) {
        this.eyeToric = eyeToric;
        this.constantA = constantA;
        this.targetRefraction = targetRefraction;
        this.isKeratoconus = isKeratoconus ? 1 : 0;
    }

    Eye(EyeNonToric eyeNonToric, EyeConstantA constantA, Boolean isKeratoconus, String targetRefraction) {
        this.eyeNonToric = eyeNonToric;
        this.constantA = constantA;
        this.targetRefraction = targetRefraction;
        this.isKeratoconus = isKeratoconus ? 1 : 0;
    }

    public JSONObject toJson() throws ParseException, IOException {
        JSONObject json = new JSONObject();
        json.put("nontoric", (this.eyeNonToric != null) ? 1 : 0 );
        json.put("toric", (this.eyeToric != null) ? 1 : 0 );
        json.put("keratoconus", this.isKeratoconus);
        json.put("target_ref", this.targetRefraction);

        json = this.embed(json, this.constantA.toJson());
        json = (this.eyeToric != null) ? this.embed(json, this.eyeToric.toJson()) : json;
        json = (this.eyeNonToric != null) ? this.embed(json, this.eyeNonToric.toJson()) : json;

        json.put("is_set", true);
        json.put("is_valid", true);

        return json;
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
