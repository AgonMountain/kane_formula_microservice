package calc;

public class Eye {

    private String isToric;
    private String isKeratoconus;
    private String targetRefraction;
    private String constantA;
    private String al;
    private String k1;
    private String k2;
    private String acd;
    private String lt;
    private String cct;

    Eye() {}

    Eye(String isToric,
        String isKeratoconus,
        String targetRefraction,
        String constantA,
        String al,
        String k1,
        String k2,
        String acd,
        String lt,
        String cct) {

        this.isToric = isToric;
        this.isKeratoconus = isKeratoconus;
        this.targetRefraction = targetRefraction;
        this.constantA = constantA;
        this.al = al;
        this.k1 = k1;
        this.k2 = k2;
        this.acd = acd;
        this.lt = lt;
        this.cct = cct;
    }

    public String getIsToric() {
        return this.isToric;
    }

    public String getIsKeratoconus() {
        return this.isKeratoconus;
    }

    public String getTargetRefraction() {
        return this.targetRefraction;
    }

    public String getConstantA() {
        return this.constantA;
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
}
