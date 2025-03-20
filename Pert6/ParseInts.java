// ****************************************************************
// ParseInts.java
//
// Reads a line of text and prints the integers in the line.
//
// ****************************************************************
import java.util.Scanner;
public class ParseInts{
    public static void main(String[] args) {
        int val, sum=0;
        Scanner scan = new Scanner(System.in);
        
        
        System.out.println("Enter a line of text");
        Scanner scanLine = new Scanner(scan.nextLine());
        
        // MODIFIED 
        /* Sebelum MODIFIED:
           Program berhenti menjumlahkan saat menemukan token non-integer.. */
        /* Penjelasan MODIFIED:
           (try) di dalam loop memastikan setiap token diproses secara independen.
           Jika terjadi (NumberFormatException), program tidak berhenti dan melanjutkan ke token berikutnya. */
        while (scanLine.hasNext()) {
            try { // TRY DI DALAM LOOP (BENAR)
                val = Integer.parseInt(scanLine.next());
                sum += val;
            } catch (NumberFormatException e) {
                // Abaikan token non-integer, loop tetap lanjut
            }
        }
        
        System.out.println("The sum of the integers on this line is " + sum);
    }
}