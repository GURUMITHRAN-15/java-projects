
public class Converter {

    public double celsiusToFahrenheit(double c) {
        return (c * 9/5) + 32;
    }

    public double fahrenheitToCelsius(double f) {
        return (f - 32) * 5/9;
    }

    public double usdToInr(double usd) {
        return usd * 83.0; // static for now
    }
}