package calc.model.dto;

import calc.model.ConstantA;
import calc.model.ConstantAType;
import calc.model.EyeNonToric;
import calc.model.EyeToric;
import calc.model.validator.EyeValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.JSONObject;


public class EyeDto {

    private @JsonProperty("is_keratoconus") Boolean isKeratoconus;
    private @JsonProperty("target_refraction") String targetRefraction;
    private @JsonProperty("constant_a") ConstantADto constantA;
    private @JsonProperty("eye_toric") EyeToricDto eyeToric;
    private @JsonProperty("eye_nontoric") EyeNonToricDto eyeNonToric;
    private EyeValidator validator;


    public EyeDto(Boolean isKeratoconus, String targetRefraction, ConstantADto constantA,
           EyeToricDto eyeToric, EyeNonToricDto eyeNonToric) {

        this.isKeratoconus = isKeratoconus;
        this.targetRefraction = targetRefraction;
        this.constantA = constantA;
        this.eyeToric = eyeToric;
        this.eyeNonToric = eyeNonToric;

        this.validator = new EyeValidator();
    }

    public boolean getIsKeratoconus() {
        return this.isKeratoconus;
    }

    public String  getTargetRefraction() {
        return this.targetRefraction;
    }

    public ConstantA getConstantA() {
        return new ConstantA(this.constantA.getValue(), this.constantA.getConstantType() == null ? ConstantAType.IOL_Type : this.constantA.getConstantType());
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

        Boolean isValid = this.validator.isTargetRefractionValid(this.targetRefraction);
        isValid = (this.eyeToric == null || this.eyeToric.isValid()) && isValid;
        isValid = (this.eyeNonToric == null || this.eyeNonToric.isValid()) && isValid;
        isValid = this.constantA.isValid() && isValid;
        isValid = this.validator.isToricEyeValid(this.eyeToric) && isValid;
        isValid = this.validator.isNontoricEyeValid(this.eyeNonToric) && isValid;
        isValid = this.validator.isEyeValid(this.eyeToric, this.eyeNonToric) && isValid;
        isValid = this.validator.isConstantAValid(this.constantA) && isValid;

        return isValid;
    }

    public JSONObject errorLogs() {
        return this.validator.getErrorLog();
    }

    public JSONObject errorMessagesRu() {
        return this.validator.getErrorMessageRu();
    }

}
