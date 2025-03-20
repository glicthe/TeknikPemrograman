package Case3;
// ****************************************************************
// MathUtils.java
//
// Provides static mathematical utility functions.
//
// ****************************************************************
public class MathUtils {
    public static int factorial(int n) {
        if (n < 0 || n > 16) {
            throw new IllegalArgumentException(
                "Input harus antara 0-16. Input tidak valid: " + n
            );
        }
        int fac = 1;
        for (int i = n; i > 0; i--) {
            fac *= i;
        }
        return fac;
    }
}
