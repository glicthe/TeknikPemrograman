package Case3;

// ****************************************************************
// Factorials.java
// Reads integers from the user and prints the factorial of each.
//
// ****************************************************************
import java.util.Scanner;
public class Factorials{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String keepGoing = "y" ;

        // MODIFIED 
        /* Sebelum MODIFIED:
           MathUtils.factorial() tidak menangani input negatif atau >16.*/
        /* Penjelasan MODIFIED:
           throw new IllegalArgumentException() digunakan untuk menghentikan eksekusi jika input tidak valid (prinsip defensive programming).
           catch di main() memastikan program tetap berjalan meskipun terjadi exception. */
        while (keepGoing.equalsIgnoreCase("y")) {
            System.out.print("Masukkan integer: ");
            try {
                int val = scan.nextInt();
                System.out.println("Factorial(" + val + ") = " + MathUtils.factorial(val));
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage()); // Tangkap exception
            } catch (java.util.InputMismatchException e) {
                System.out.println("Input harus bilangan integer!");
                scan.next(); // Clear input invalid
            }

            System.out.print("Lanjutkan? (y/n): ");
            keepGoing = scan.next();
        }
    }
}