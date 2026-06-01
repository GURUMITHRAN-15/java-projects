import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {

    public BigDecimal basicOperation(int choice, String a, String b) {
        BigDecimal num1 = new BigDecimal(a);
        BigDecimal num2 = new BigDecimal(b);

        return switch (choice) {
            case 1 -> num1.add(num2);
            case 2 -> num1.subtract(num2);
            case 3 -> num1.multiply(num2);
            case 4 -> {
                if (num2.compareTo(BigDecimal.ZERO) == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                yield num1.divide(num2, 10, RoundingMode.HALF_UP);
            }
            default -> BigDecimal.ZERO;
        };
    }

    public double squareRoot(double num) {
        return Math.sqrt(num);
    }

    public double power(double base, double exp) {
        return Math.pow(base, exp);
    }
}