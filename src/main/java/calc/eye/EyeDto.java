package calc.eye;

import calc.eye.constantA.*;

import calc.eye.constantA.EyeConstantA;
import calc.eye.constantA.EyeConstantADto;
import calc.eye.nontoric.EyeNonToric;
import calc.eye.nontoric.EyeNonToricDto;
import calc.eye.toric.EyeToric;
import calc.eye.toric.EyeToricDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.JSONObject;

public class EyeDto {


    private @JsonProperty("is_keratoconus") Boolean isKeratoconus;
    private @JsonProperty("target_refraction") String targetRefraction;
    private @JsonProperty("constant_a") EyeConstantADto constantA;
    private @JsonProperty("eye_toric") EyeToricDto eyeToric;
    private @JsonProperty("eye_nontoric") EyeNonToricDto eyeNonToric;

    private JSONObject errors;

    public EyeDto(Boolean isKeratoconus, String targetRefraction, EyeConstantADto constantA,
           EyeToricDto eyeToric, EyeNonToricDto eyeNonToric) {

        this.isKeratoconus = isKeratoconus;
        this.targetRefraction = targetRefraction;
        this.constantA = constantA;
        this.eyeToric = eyeToric;
        this.eyeNonToric = eyeNonToric;

        this.errors = new JSONObject();
    }

    public boolean getIsKeratoconus() {
        return this.isKeratoconus;
    }

    public String  getTargetRefraction() {
        return this.targetRefraction;
    }

    public EyeConstantA getConstantA() {
        return new EyeConstantA(this.constantA.getConstantA(), this.constantA.getConstantType());
    }

    public EyeToric getEyeToric() {
        return this.eyeToric != null ? new EyeToric(
                                        this.eyeToric.getAl(),
                                        this.eyeToric.getK1(),
                                        this.eyeToric.getK1axis(),
                                        this.eyeToric.getK2(),
                                        this.eyeToric.getK2axis(),
                                        this.eyeToric.getAcd(),
                                        this.eyeToric.getLt(),
                                        this.eyeToric.getCct(),
                                        this.eyeToric.getIncision(),
                                        this.eyeToric.getSia()) : null;
    }

    public EyeNonToric getEyeNonToric() {
        return this.eyeNonToric != null ? new EyeNonToric(
                                            this.eyeNonToric.getAl(),
                                            this.eyeNonToric.getK1(),
                                            this.eyeNonToric.getK2(),
                                            this.eyeNonToric.getAcd(),
                                            this.eyeNonToric.getLt(),
                                            this.eyeNonToric.getCct()) : null;
    }

    public boolean isValid() {
        EyeValidator validator = new EyeValidator();

        Boolean isValid = validator.isTargetRefractionValid(this.targetRefraction);
        isValid = (this.eyeToric == null || this.eyeToric.isValid()) && isValid;
        isValid = (this.eyeNonToric == null || this.eyeNonToric.isValid()) && isValid;
        isValid = this.constantA.isValid() && isValid;

        this.errors = validator.errors();

        if (this.eyeNonToric != null && this.eyeNonToric.errors().length() != 0) {
            this.errors.put("eye", this.eyeNonToric.errors());
        }

        if (this.eyeToric != null && this.eyeToric.errors().length() != 0) {
            this.errors.put("eye", this.eyeToric.errors());
        }

        // not set eye (toric / nontoric)
        if (this.eyeToric == null && this.eyeNonToric == null) {
            this.errors.put("eye", "None");
        }

        if (this.constantA.errors().length() != 0) {
            this.errors.put("constant_a", this.constantA.errors());
        }

        return isValid;
    }

    public JSONObject errors() {
        return this.errors;
    }

}
