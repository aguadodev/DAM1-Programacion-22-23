import maquinaria.Locomotora;
import maquinaria.Tren;
import personal.Maquinista;
import personal.Mecanico;

public class Ferrocarril {
    public static void main(String[] args) {
        Mecanico mec = new Mecanico("Marta Pérez", "8768768768", "MOTOR");
        Locomotora locomotora = new Locomotora("6543asd", 500, 2000, mec);
        Maquinista maq = new Maquinista("Pepe López", "12312312G", 40000, "SENIOR");

        Tren tren = new Tren();
        tren.addVagon(23, 5000, 5000, "Madera");;
        tren.addVagon(76, 5000, 2000, "Hierro");;
        tren.addVagon(98, 2000, 1000, "Personas");;
        tren.setLocomotora(locomotora);
        tren.setMaquinista(maq);                                 
        
        System.out.println(tren);
        System.out.print("CARGA: " + tren.getCargaActual() + "/" + 
                            tren.getCapacidadMaxima() + " : ");
        System.out.printf("%.2f %% %n", tren.getPorcentajeCarga() * 100);                     
    }
}
