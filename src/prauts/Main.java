package prauts;

public class Main {
    public static void main(String[] args) {
        Buku buku1 = new Buku("Pemrograman Java", "Anggi Maulana", 2020);

        Anggota anggota1 = new Anggota("Anggita", "A001");
        anggota1.setBukuDipinjam(buku1);
        anggota1.infoAnggota();

        System.out.println("\n=== Data Siswa ===");
        Siswa siswa1 = new Siswa("Anggii", "S001", "D4SIKC2C");
        siswa1.setBukuDipinjam(buku1);
        siswa1.infoAnggota();
    }
}
