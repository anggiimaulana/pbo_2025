import java.util.Scanner;

public class Pbo_pertama {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int jumlah = 0;

        // Validasi input jumlah mahasiswa agar hanya menerima angka
        while (true) {
            System.out.print("Masukkan jumlah mahasiswa: ");
            if (input.hasNextInt()) {
                jumlah = input.nextInt();
                if (jumlah > 0) {
                    input.nextLine();
                    break;
                } else {
                    System.out.println("Jumlah mahasiswa harus lebih dari 0!");
                }
            } else {
                System.out.println("Input tidak valid! Harap masukkan angka.");
                input.next();
            }
        }

        // Array untuk menyimpan data mahasiswa
        String[] namaLengkap = new String[jumlah];
        int[] nim = new int[jumlah];
        String[] prodi = new String[jumlah];
        String[] minat = new String[jumlah];
        String[] jenisKelamin = new String[jumlah];

        // Input data mahasiswa
        for (int i = 0; i < jumlah; i++) {
            System.out.println("\n=== Masukkan Data Mahasiswa ke-" + (i + 1) + " ===");

            System.out.print("Masukkan Nama Lengkap: ");
            namaLengkap[i] = input.nextLine();

            System.out.print("Masukkan NIM: ");
            while (!input.hasNextInt()) {
                System.out.println("Input tidak valid! Harap masukkan angka untuk NIM.");
                input.next(); 
            }
            nim[i] = input.nextInt();
            input.nextLine(); 

            System.out.print("Masukkan Prodi: ");
            prodi[i] = input.nextLine();

            System.out.print("Masukkan Minat Anda: ");
            minat[i] = input.nextLine();

            // Validasi input jenis kelamin
            int jk;
            while (true) {
                System.out.print("Masukkan Jenis Kelamin (1 = Laki-Laki, 0 = Perempuan): ");
                if (input.hasNextInt()) {
                    jk = input.nextInt();
                    input.nextLine(); 
                    if (jk == 1 || jk == 0) {
                        break; 
                    } else {
                        System.out.println("Input tidak valid! Harap masukkan 1 untuk Laki-Laki atau 0 untuk Perempuan.");
                    }
                } else {
                    System.out.println("Input tidak valid! Harap masukkan angka 1 atau 0.");
                    input.next(); 
                }
            }
            jenisKelamin[i] = (jk == 1) ? "Laki-Laki" : "Perempuan";
        }

        // Menampilkan data mahasiswa
        System.out.println("\n===== Data Mahasiswa =====");
        for (int i = 0; i < jumlah; i++) {
            System.out.println("\nMahasiswa ke-" + (i + 1));
            System.out.println("Nama Lengkap : " + namaLengkap[i]);
            System.out.println("NIM          : " + nim[i]);
            System.out.println("Prodi        : " + prodi[i]);
            System.out.println("Jenis Kelamin: " + jenisKelamin[i]);
            System.out.println("Minat        : " + minat[i]);
        }

        input.close(); // Menutup Scanner
    }
}
