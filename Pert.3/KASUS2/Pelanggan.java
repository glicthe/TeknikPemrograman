package KASUS2;

public class Pelanggan {
    private int idPelanggan;
    private String nama;
    private String email;
    private String nomorHP;

    public Pelanggan(int idPelanggan, String nama, String email, String nomorHP) {
        this.idPelanggan = idPelanggan;
        this.nama = nama;
        this.email = email;
        this.nomorHP = nomorHP;
    }

    public int getIdPelanggan() { return idPelanggan; }
    public String getNama() { return nama; }
    public String getEmail() { return email; }
    public String getNomorHP() { return nomorHP; }
}
