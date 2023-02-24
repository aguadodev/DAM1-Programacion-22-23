package animales;

public interface Sonido {
    int version = 1;
    void voz();

    default void vozDurmiendo(){
        System.out.println("Zzzzz");
    }

    static void bostezo(){
        System.out.println("Aaaauuuuh!");
    }
}
