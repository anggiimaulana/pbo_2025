public class Kalkulator {
    //    Modifier
    protected double angka1, angka2;
        
    //    Constructor
    public Kalkulator (double angka1, double angka2) {
        this.angka1 = angka1;
        this.angka2 = angka2;
    }
        
    public double tambah() {
        return angka1 + angka2;
    }
        
    public double kurang() {
        return angka1 - angka2;
    }
        
    public double kali() {
        return angka1 * angka2;
    }
        
    public double bagi() {
        return (angka2 != 0) ? angka1 / angka2 : 0;
    }
} 
