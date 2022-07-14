package calc;


public class EyeNonToricDto {

    private String al;
    private String k1;
    private String k2;
    private String acd;
    private String lt;
    private String cct;

    EyeNonToricDto(String al, String k1, String k2, String acd, String lt, String cct) {
        this.al = al;
        this.k1 = k1;
        this.k2 = k2;
        this.acd = acd;
        this.lt = lt;
        this.cct = cct;
    }

    public String getAl() {
        return this.al;
    }

    public String getK1() {
        return this.k1;
    }

    public String getK2() {
        return this.k2;
    }

    public String getAcd() {
        return this.acd;
    }

    public String getLt() {
        return this.lt;
    }

    public String getCct() {
        return this.cct;
    }

    public boolean isValid() {
        EyeNonToricValidator validator = new EyeNonToricValidator();

        return (validator.isAlValid(this.al) &&
                validator.isK1Valid(this.k1) &&
                validator.isK2Valid(this.k1, this.k2) &&
                validator.isAcdValid(this.acd) &&
                validator.isLtValid(this.lt) &&
                validator.isCctValid(this.cct));
    }

}
