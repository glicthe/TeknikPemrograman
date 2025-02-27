package KASUS2;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Pemesanan {
    private int idPemesanan;
    private LocalDateTime pemesanan;
    private Pelanggan pelanggan;
    private Tiket tiket;
    private LocalDate tanggalPemesanan;

    public Pemesanan(int idPemesanan, Pelanggan pelanggan, Tiket tiket) {
        this.idPemesanan = idPemesanan;
        this.pelanggan = pelanggan;
        this.tiket = tiket;
        this.pemesanan = LocalDateTime.now();
        this.tanggalPemesanan = pemesanan.toLocalDate();
        tiket.setStatusTerjual(); // Tiket otomatis ditandai sebagai terjual saat dipesan
    }

    public int getIdPemesanan() { return idPemesanan; }
    public Pelanggan getPelanggan() { return pelanggan; }
    public Tiket getTiket() { return tiket; }
    public LocalDate getTanggalPemesanan() { return tanggalPemesanan; }

    public void displayDetailPemesanan() {
        System.out.println("\n========Detail Pemesanan========");
        System.out.println("ID Pemesanan        : " + idPemesanan);
        System.out.println("Nama Pelanggan      : " + pelanggan.getNama());
        System.out.println("Film                : " + tiket.getFilm().getJudul());
        System.out.println("Harga Tiket         : " + tiket.getHarga());
        System.out.println("Tanggal Pemesanan   : " + tanggalPemesanan);
        System.out.println("Status Tiket        : " + (tiket.isTerjual() ? "Terjual" : "Belum Terjual"));
    }
}
