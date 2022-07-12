package calc;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Calculation {

    private @Id @GeneratedValue long id;
    private int x;
    private int y;
    private String op;
    private String result;

    Calculation() {}

    Calculation(String x, String y, String op) {
        this.x = Integer.parseInt(x);
        this.y = Integer.parseInt(y);
        this.op = op;

        this.result = "None";

        switch (op) {
            case "+" -> this.result = Integer.toString(this.x + this.y);
            case "-" -> this.result = Integer.toString(this.x - this.y);
            case "*" -> this.result = Integer.toString(this.x * this.y);
            case "/" -> this.result = Integer.toString(this.x / this.y);
        }
    }

    Calculation(CalculationDto dto) {
        this.x = Integer.parseInt(dto.getX());
        this.y = Integer.parseInt(dto.getY());
        this.op = dto.getOp();

        this.result = "None";

        switch (op) {
            case "+" -> this.result = Integer.toString(this.x + this.y);
            case "-" -> this.result = Integer.toString(this.x - this.y);
            case "*" -> this.result = Integer.toString(this.x * this.y);
            case "/" -> this.result = Integer.toString(this.x / this.y);
        }
    }

    public Long getId() {
        return this.id;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public String getOp() {
        return this.op;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public void updateResult() {
        this.result = "None";

        switch (op) {
            case "+" -> this.result = Integer.toString(this.x + this.y);
            case "-" -> this.result = Integer.toString(this.x - this.y);
            case "*" -> this.result = Integer.toString(this.x * this.y);
            case "/" -> this.result = Integer.toString(this.x / this.y);
        }
    }

    public String getResult() {
        return this.result;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Calculation))
            return false;
        Calculation calc = (Calculation) o;
        return Objects.equals(this.id, calc.id)
                && Objects.equals(this.x, calc.x)
                && Objects.equals(this.y, calc.y)
                && Objects.equals(this.op, calc.op)
                && Objects.equals(this.result, calc.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.x, this.y, this.op, this.result);
    }

    @Override
    public String toString() {
        return "Calculation " + this.id + " {" + this.x + " " + this.op + " " + this.y + " = " + this.result + "}";
    }
}
