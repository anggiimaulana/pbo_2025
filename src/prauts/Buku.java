package prauts;

public class Buku {
    private String judul;
    private String penulis;
    private int tahunTerbit;

    public Buku(String judul, String penulis, int tahunTerbit) {
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
    }

    public String getJudul() {
        return judul;
    }
}

class Anggota {
    private String nama;
    private String idAnggota;
    private Buku bukuDipinjam;

    public Anggota(String nama, String idAnggota) {
        this.nama = nama;
        this.idAnggota = idAnggota;
        this.bukuDipinjam = null; // Awalnya tidak meminjam buku
    }

    // Getter
    public String getNama() {
        return nama;
    }

    public String getIdAnggota() {
        return idAnggota;
    }

    public Buku getBukuDipinjam() {
        return bukuDipinjam;
    }

    // Setter
    public void setBukuDipinjam(Buku bukuDipinjam) {
        this.bukuDipinjam = bukuDipinjam;
    }

    // Method untuk menampilkan informasi anggota
    public void infoAnggota() {
        System.out.println("Nama: " + nama);
        System.out.println("ID Anggota: " + idAnggota);
        if (bukuDipinjam != null) {
            System.out.println("Buku yang Dipinjam: " + bukuDipinjam.getJudul());
        } else {
            System.out.println("Tidak ada buku yang dipinjam.");
        }
    }
}

class Siswa extends Anggota {
    private String kelas;

    public Siswa(String nama, String idAnggota, String kelas) {
        super(nama, idAnggota);
        this.kelas = kelas;
    }

    @Override
    public void infoAnggota() {
        super.infoAnggota();
        System.out.println("Kelas: " + kelas);
    }
}