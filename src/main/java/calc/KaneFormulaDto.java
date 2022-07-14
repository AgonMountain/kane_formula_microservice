package calc;


import calc.eye.Eye;
import calc.eye.EyeDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.JSONObject;

public class KaneFormulaDto {

    private @JsonProperty("surgeon_name") String surgeonName;
    private @JsonProperty("patient_name") String patientName;
    private @JsonProperty("patient_id") String patientId;
    private @JsonProperty("k_index") String kIndex;
    private @JsonProperty("is_male") Boolean isMale;
    private @JsonProperty("right_eye") EyeDto rightEye;
    private @JsonProperty("left_eye") EyeDto leftEye;

    private JSONObject errors;

    public KaneFormulaDto(String surgeonName, String patientName, String patientId,
                   String kIndex, Boolean isMale, EyeDto rightEye, EyeDto leftEye) {
        this.surgeonName = surgeonName;
        this.patientName = patientName;
        this.patientId = patientId;
        this.kIndex = kIndex;
        this.isMale = isMale;
        this.rightEye = rightEye;
        this.leftEye = leftEye;

        this.errors = new JSONObject();
    }

    public String getSurgeonName() {
        return this.surgeonName;
    }

    public String getPatientName() {
        return this.patientName;
    }

    public String getPatientId() {
        return this.patientId;
    }

    public String getKIndex() {
        return this.kIndex;
    }

    public Boolean getIsMale() {
        return this.isMale;
    }

    public Eye getRightEye() {

        if (this.rightEye != null) {
            if (this.rightEye.getEyeToric() != null) {
                return new Eye(this.rightEye.getEyeToric(), this.rightEye.getConstantA(),
                        this.rightEye.getIsKeratoconus(), this.rightEye.getTargetRefraction());
            }
            else {
                return new Eye(this.rightEye.getEyeNonToric(), this.rightEye.getConstantA(),
                        this.rightEye.getIsKeratoconus(), this.rightEye.getTargetRefraction());
            }
        }
        return null;
    }

    public Eye getLeftEye() {

        if (this.leftEye != null) {
            if (this.leftEye.getEyeToric() != null) {
                return new Eye(this.leftEye.getEyeToric(), this.leftEye.getConstantA(),
                        this.leftEye.getIsKeratoconus(), this.leftEye.getTargetRefraction());
            }
            else {
                return new Eye(this.leftEye.getEyeNonToric(), this.leftEye.getConstantA(),
                        this.leftEye.getIsKeratoconus(), this.leftEye.getTargetRefraction());
            }
        }
        return null;
    }


    public boolean isValid() {
        KaneFormulaValidator validator = new KaneFormulaValidator();

        Boolean isValid = validator.isKindexValid(this.kIndex);
        isValid = (this.rightEye.isValid() || this.rightEye == null) && isValid;
        isValid = (this.leftEye.isValid() || this.leftEye == null) && isValid;

        this.errors = validator.errors();

        if (this.rightEye.errors().length() != 0) {
            this.errors.put("right_eye", this.rightEye.errors());
        }
        if (this.leftEye.errors().length() != 0) {
            this.errors.put("left_eye", this.leftEye.errors());
        }

        return isValid;
    }

    public JSONObject errors() {
        return this.errors;
    }
}
