package calc;


import com.fasterxml.jackson.annotation.JsonProperty;

public class EyeDto {


    private @JsonProperty("is_keratoconus") String isKeratoconus;
    private @JsonProperty("target_refraction") String targetRefraction;
    private @JsonProperty("constant_a") EyeConstantADto constantA;
    private @JsonProperty("eye_toric") EyeToricDto eyeToric;
    private @JsonProperty("eye_nontoric") EyeNonToricDto eyeNonToric;


    EyeDto(String isKeratoconus, String targetRefraction, EyeConstantADto constantA,
           EyeToricDto eyeToric, EyeNonToricDto eyeNonToric) {

        this.isKeratoconus = isKeratoconus;
        this.targetRefraction = targetRefraction;
        this.constantA = constantA;
        this.eyeToric = eyeToric;
        this.eyeNonToric = eyeNonToric;
    }

    public boolean getIsKeratoconus() {
        return this.isKeratoconus.equals("1");
    }

    public String getTargetRefraction() {
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

        return validator.isTargetRefractionValid(this.targetRefraction) &&
                (this.eyeToric == null || this.eyeToric.isValid()) &&
                (this.eyeNonToric == null || this.eyeNonToric.isValid()) &&
                this.constantA.isValid();
    }

}
