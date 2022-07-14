package calc;

public class EyeToricValidator {

    public boolean isAlValid(String al) {
        return 18 <= Float.parseFloat(al) && Float.parseFloat(al) <= 35;
    }

    public boolean isK1Valid(String k1) {
        return 30 <= Float.parseFloat(k1) && Float.parseFloat(k1) <= 65;
    }

    public boolean isK2Valid(String k1, String k2) {
        return (30 <= Float.parseFloat(k2) && Float.parseFloat(k2) <= 65) &&
                (Float.parseFloat(k1) <= Float.parseFloat(k2));
    }

    public boolean isAcdValid(String acd) {
        return 1.5 <= Float.parseFloat(acd) && Float.parseFloat(acd) <= 5;
    }

    public boolean isLtValid(String lt) {
        return 2.5 <= Float.parseFloat(lt) && Float.parseFloat(lt) <= 8;
    }

    public boolean isCctValid(String cct) {
        return 350 <= Float.parseFloat(cct) && Float.parseFloat(cct) <= 650;
    }

    public boolean isSiaValid(String sia) {
        return 0 <= Float.parseFloat(sia) && Float.parseFloat(sia) <= 1;
    }

    public boolean isIncisionValid(String incision) {
        return 0 <= Float.parseFloat(incision) && Float.parseFloat(incision) <= 360;
    }

    public boolean isK1axisValid(String k1axis) {
        return 0 <= Float.parseFloat(k1axis) && Float.parseFloat(k1axis) <= 180;
    }

    // TODO idk how it is calculated
//    public boolean isK2axisValid(String k2axis) {
//        return 0 <= Float.parseFloat(k1axis) && Float.parseFloat(k1axis) <= 180;
//    }

}
