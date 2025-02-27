import java.util.ArrayList;

public class buku {
    //atributnya
    private String judul;
    private String genre;
    private double harga;

    //membuat konstruktornya
    public buku(String judul, String genre, double harga) {
        this.judul = judul;
        this.genre = genre;
        this.harga = harga;
    }

    //getter untuk atribut
    public String getJdl(){
        return judul;
    }

    public String getGnr() {
        return genre;
    }

    public double getHrg() {
        return harga;
    }

    //method untuk menampilkan buku
    public void tampilkanInfo() {
        System.out.println("Judul Buku: " + getJdl());
        System.out.println("Genre Buku: " + getGnr());
        System.out.println("Harga Buku: " + getHrg());
    }


    public static void main(String[] args) {
        //membuat objek TokoBuku
        TokoBuku toko = new TokoBuku("Glicthe Book");

        //membuat objek beberapa buku
        buku buku1 = new buku("The Idiots", "Fiction", 85000);
        buku buku2 = new buku("Everything is Fcked", "Self Development", 130000);

        //menambahkan buku ke toko
        toko.tambahBuku(buku1);
        toko.tambahBuku(buku2);

        //menampilkan daftar buku yang ada di toko
        toko.tampilkanDaftarBuku();
    }

}


class TokoBuku{
    //atributnya
    private String namaToko;
    private ArrayList<buku> daftarBuku;

    //konstruktor
    public TokoBuku(String namaToko){
        this.namaToko = namaToko;
        this.daftarBuku = new ArrayList<>();
    }

    //metode untuk menambahkan buku
    public void tambahBuku(buku buku) {
        daftarBuku.add(buku);
    }
    
    //metode untuk menampilkan daftar buku
    public void tampilkanDaftarBuku() {
        System.out.println("Daftar Buku di " + namaToko + ":");
        for (buku buku : daftarBuku) {
            buku.tampilkanInfo();
            System.out.println("-------------------");
        }
    }
    
}


