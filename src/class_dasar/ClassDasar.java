package class_dasar;
import java.util.Scanner;

class Kalkulator {
    protected double angka1, angka2;
    
    public Kalkulator(double angka1, double angka2) {
        this.angka1 = angka1;
        this.angka2 = angka2;
    }
    
    public double tambah() { return angka1 + angka2; }
    public double kurang() { return angka1 - angka2; }
    public double kali() { return angka1 * angka2; }
    public double bagi() { return (angka2 != 0) ? angka1 / angka2 : 0; }
}

class KalkulatorBMI {
    private double berat, tinggi;
    
    public KalkulatorBMI(double berat, double tinggi) {
        this.berat = berat;
        this.tinggi = tinggi;
    }
    
    public double hitungBMI() { return berat / (tinggi * tinggi); }
    
    public String kategoriBMI() {
        double bmi = hitungBMI();
        if (bmi < 18.5) return "Anda kurang gizi";
        else if (bmi < 24.9) return "Anda ideal";
        else if (bmi < 29.9) return "Anda gemuk";
        else return "Anda obesitas";
    }
}

class KalkulatorBangunDatar {
    public double luasPersegi(double sisi) { return sisi * sisi; }
    public double luasLingkaran(double radius) { return Math.PI * radius * radius; }
}

class KalkulatorBangunRuang {
    public double volumeBalok(double panjang, double lebar, double tinggi) { return panjang * lebar * tinggi; }
    public double volumeKubus(double sisi) { return sisi * sisi * sisi; }
}

public class ClassDasar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char pilihan;
        
        do {
            System.out.println("\nMENU:");
            System.out.println("a: Kalkulator");
            System.out.println("b: BMI");
            System.out.println("c: Bangun Ruang");
            System.out.println("d: Bangun Datar");
            System.out.println("e: Exit");
            System.out.print("Pilih menu: ");
            pilihan = input.next().charAt(0);
            
            switch (pilihan) {
                case 'a':
                    System.out.println("\nSelamat datang di Kalkulator Biasa");
                    System.out.println("==================================");
                    System.out.print("Masukan angka pertama: ");
                    double x = input.nextDouble();
                    System.out.print("Masukan angka kedua: ");
                    double y = input.nextDouble();
                    Kalkulator kalkulator = new Kalkulator(x, y);
                    System.out.println("Tambah: " + kalkulator.tambah());
                    System.out.println("Kurang: " + kalkulator.kurang());
                    System.out.println("Kali: " + kalkulator.kali());
                    System.out.println("Bagi: " + kalkulator.bagi());
                    break;
                case 'b':
                    System.out.println("\nSelamat datang di Kalkulator BMI");
                    System.out.println("================================");
                    System.out.print("Masukan berat badan (kg): ");
                    double berat = input.nextDouble();
                    System.out.print("Masukan tinggi badan (cm): ");
                    double tinggiCm = input.nextDouble();
                    double tinggiM = tinggiCm / 100;
                    KalkulatorBMI bmi = new KalkulatorBMI(berat, tinggiM);
                    System.out.println("BMI anda: " + bmi.hitungBMI());
                    System.out.println("Kategori: " + bmi.kategoriBMI());
                    break;
                case 'c':
                    System.out.println("\nSelamat datang di Kalkulator Bangun Ruang");
                    System.out.println("=========================================");
                    System.out.print("Masukan panjang balok: ");
                    double p = input.nextDouble();
                    System.out.print("Masukan lebar balok: ");
                    double l = input.nextDouble();
                    System.out.print("Masukan tinggi balok: ");
                    double t = input.nextDouble();
                    KalkulatorBangunRuang br = new KalkulatorBangunRuang();
                    System.out.println("Volume balok: " + br.volumeBalok(p, l, t));
                    System.out.print("Masukan sisi kubus: ");
                    double sisiKubus = input.nextDouble();
                    System.out.println("Volume kubus: " + br.volumeKubus(sisiKubus));
                    break;
                case 'd':
                    System.out.println("\nSelamat datang di Kalkulator Bangun Datar");
                    System.out.println("=========================================");
                    System.out.print("Masukan panjang sisi persegi: ");
                    double sisi = input.nextDouble();
                    KalkulatorBangunDatar bd = new KalkulatorBangunDatar();
                    System.out.println("Luas persegi: " + bd.luasPersegi(sisi));
                    System.out.print("Masukan jari-jari lingkaran: ");
                    double radius = input.nextDouble();
                    System.out.println("Luas lingkaran: " + bd.luasLingkaran(radius));
                    break;
                case 'e':
                    System.out.println("\nTerima kasih sudah menggunakan aplikasi ini><");
                    System.out.println("=============================================\n");
                    break;
                default:
                    System.out.println("\nPilihan tidak valid!");
            }
        } while (pilihan != 'e');
        
        input.close();
    }
}