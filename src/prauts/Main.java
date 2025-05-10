package prauts;

public class Main {
    public static void main(String[] args) {
        Buku buku1 = new Buku("Pemrograman Berorientasi Objek Dengan Java", "Syahirah", 2025);

        Anggota anggota1 = new Anggota("nana", "AGT01");
        anggota1.setBukuDipinjam(buku1);
        anggota1.infoAnggota();

        System.out.println("\n=== Data Siswa ===");
        Siswa siswa1 = new Siswa("nita", "SW01", "D4SIKC2C");
        siswa1.setBukuDipinjam(buku1);
        siswa1.infoAnggota();
    }
}
