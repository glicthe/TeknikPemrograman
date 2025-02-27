package KASUS2;

import java.util.ArrayList;
import java.util.Scanner;

public class BioskopMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        // List Film
        ArrayList<Film> daftarFilm = new ArrayList<>();
        daftarFilm.add(new Film("Batman: The Dark Knight", "Action", 181, "20:00", 50000));
        daftarFilm.add(new Film("Toy Story 3", "Animation", 100, "18:30", 40000));
        daftarFilm.add(new Film("Tennet", "Psychology", 180, "21:30", 50000));
        daftarFilm.add(new Film("Interstellar", "Sci-Fi", 180, "20:30", 50000));
        daftarFilm.add(new Film("Runner Maze", "Action", 180, "20:10", 50000));
        daftarFilm.add(new Film("John Wick 3", "Action", 186, "17:30", 55000));
        daftarFilm.add(new Film("Frozen 3", "Animation", 180, "16:30", 50000));

        // Menampilkan daftar film
        System.out.println("========Daftar Film========");
        for (int i = 0; i < daftarFilm.size(); i++) {
            System.out.println((i + 1) + ". " + daftarFilm.get(i).getJudul() + " (" + daftarFilm.get(i).getJadwalTayang() + ")");
        }

        // Input pilihan film
        System.out.print("Pilih film (masukkan nomor)   : ");
        int pilihanFilm = scanner.nextInt();
        scanner.nextLine(); // Membersihkan buffer
        if (pilihanFilm < 1 || pilihanFilm > daftarFilm.size()) {
            System.out.println("Pilihan tidak valid.");
        }
        Film filmDipilih = daftarFilm.get(pilihanFilm - 1);
        
        // Input data pelanggan
        System.out.print("Masukkan nama Anda            : ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan email Anda           : ");
        String email = scanner.nextLine();
        System.out.print("Masukkan nomor HP Anda        : ");
        String nomorHP = scanner.nextLine();

        // Membuat objek pelanggan
        Pelanggan pelanggan = new Pelanggan(1, nama, email, nomorHP);

        // Membuat tiket dan pemesanan
        Tiket tiket = new Tiket(101, filmDipilih);
        Pemesanan pemesanan = new Pemesanan(1001, pelanggan, tiket);

        // Menampilkan detail pemesanan
        pemesanan.displayDetailPemesanan();

        scanner.close();
    }
}