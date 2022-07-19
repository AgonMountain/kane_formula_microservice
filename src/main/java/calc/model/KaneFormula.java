package calc.model;


import java.io.IOException;
import java.text.ParseException;


public class KaneFormula {

    private String surgeonName;
    private String patientName;
    private String patientId;
    private String kIndex;
    private boolean isMale;
    private Eye rightEye;
    private Eye leftEye;


    public KaneFormula() throws ParseException, IOException {

    }

    public KaneFormula(String surgeonName, String patientName, String patientId, String kIndex,
                       boolean isMale,  Eye rightEye, Eye leftEye) throws ParseException, IOException {
        this.surgeonName = surgeonName;
        this.patientName = patientName;
        this.patientId = patientId;
        this.kIndex = kIndex;
        this.isMale = isMale;
        this.rightEye = rightEye;
        this.leftEye = leftEye;
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

    public Boolean isMale() {
        return this.isMale;
    }

    public Eye getRightEye() {
        return this.rightEye;
    }

    public Eye getLeftEye() {
        return this.leftEye;
    }

}
