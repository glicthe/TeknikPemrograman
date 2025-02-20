import java.util.Scanner; // import the scanner class

public class Soal5{
    static String[] inputUser(){
        Scanner inputln = new Scanner(System.in);
        System.out.print("Enter The First Line: ");
        String firstln = inputln.nextLine(); // input line pertama
        System.out.print("Enter The Second Line: ");
        String secondln = inputln.nextLine(); // input line kedua

        
        //return the string to an array
        return new String[]{firstln, secondln};
    }

    public static void main(String[] args){
        String[] input = inputUser(); //menaruh nilai return dari inputUser
        String firstln = input[0];    //Akses ke indeks 0 untuk mengambil line pertama
        String secondln = input[1];   //Akses ke indeks 1 untuk mengambil line kedua
        
        //menghitung panjang total kata
        int totalLength = (int) firstln.length() + (int) secondln.length(); //menghitung panjang kedua kata tersebut
        System.out.println(totalLength);

        //mengcompare string secara lexicographically
        int compare = firstln.compareToIgnoreCase(secondln); //meng-compare string secara lexicographically dan menghiraukan jika ada huruf kapital 
        String result = (compare < 0) ? "No" : (compare < 0) ? "Yes" : "same"; //if else statement secara ternary code
        System.out.println(result);

        //uppercase huruf pertama dan menggambungkan kata
        //substring untuk mengiris string indeks 0 lalu toUppercase untuk merubah ke kapital lalu menggabungkan lagi kata nya
        String newFirstln = firstln.substring(0, 1).toUpperCase() + firstln.substring(1);
        String newSecondln = secondln.substring(0, 1).toUpperCase() + secondln.substring(1);
        System.out.println(newFirstln + " " + newSecondln);
    }
}