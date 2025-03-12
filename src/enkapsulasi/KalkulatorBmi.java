public class KalkulatorBmi {
    private double berat, tinggi;
    
    public KalkulatorBmi(double berat, double tinggi) {
        this.berat = berat;
        this.tinggi = tinggi;
    }
    
    public double hitungBMI() {
        return berat / (tinggi * tinggi);
    }
    
    public String kategoriBMI() {
        double bmi = hitungBMI();
        
        if (bmi < 18.5) return "Anda kurang gizi";
        else if (bmi < 24.9) return "Anda ideal";
        else if (bmi < 29.9) return "Anda gemuk";
        else return "Anda obesitas";
    }
} 
