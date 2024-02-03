package helpers;

public class Calculation {
    public static String CalculateValue(String value) {
        int xValue = Integer.parseInt(value);
        return String.valueOf(Math.log(Math.abs(12 * Math.sin(xValue))));
    }
}
