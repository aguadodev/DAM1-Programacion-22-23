public class Iva {

    static double iva(double importeBase, int tipo) {
        return importeBase * tipo / 100;
    }
    static double importeBase(double importeTotal, int tipo) {
        return importeTotal / (1 + tipo / 100.0);
    }
    public static void main(String[] args) {
        double importeTotal = 100;
        
        double importeBase = importeBase(importeTotal, 21);

        System.out.printf("21%% de IVA de un importe base de 100€: %.2f€ %n", iva(100, 21));
        System.out.printf("Importe Base de un producto cuyo importe total es 100€ y tiene un IVA del 21%%: %.2f€ %n", importeBase(100, 21));
    }
}
