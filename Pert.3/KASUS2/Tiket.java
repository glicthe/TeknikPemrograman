package KASUS2;

public class Tiket {
    private int idTiket;
    private Film film;
    private double harga;
    private boolean statusTerjual;

    public Tiket(int idTiket, Film film) {
        this.idTiket = idTiket;
        this.film = film;
        this.harga = film.getHargaTiket();
        this.statusTerjual = false; // Awalnya belum terjual
    }

    public int getIdTiket() { return idTiket; }
    public Film getFilm() { return film; }
    public double getHarga() { return harga; }
    public boolean isTerjual() { return statusTerjual; }

    public void setStatusTerjual() {
        this.statusTerjual = true;
    }
}
