import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Texto
 */
public class Texto {
    // Atributos
    private String cad;
    private int maxLength;
    private LocalDate createdAt;
    private LocalDateTime updatedAt;
    private int vocales;


    // Métodos
    // - Constructor/es
    public Texto(int maxLength) {
        this.cad = new String();
        this.maxLength = maxLength;
        this.createdAt = LocalDate.now();
        this.vocales = 0;
    }   

    // - Otros métodos
    public boolean add(char ch){
        return add(ch, false);
    }

    public boolean add(String str){
        return add(str, false);
    }

    public boolean add(char ch, boolean inicio){
        boolean modificado = false;
        if (cad.length() < maxLength){
            if (inicio)
                cad = ch + cad;
            else
                cad = cad + ch;
            if (esVocal(ch))
                vocales++;                   
            this.updatedAt = LocalDateTime.now();
            modificado = true;
        }
        return modificado;
    }

    public boolean add(String str, boolean inicio){
        boolean modificado = false;
        if (cad.length() + str.length() <= maxLength){
            if (inicio)
                cad = str + cad;
            else
                cad = cad + str;

            for(int i = 0; i < str.length(); i++)
                if (esVocal(str.charAt(i)))
                    vocales++;

            this.updatedAt = LocalDateTime.now();
            modificado = true;                    
        }
        return modificado;                        
    }

    @Override
    public String toString() {
        return "Texto [cad=" + cad + ", maxLength=" + maxLength + ", createdAt=" + createdAt + ", updatedAt="
                + updatedAt + ", vocales=" + vocales + "]";
    }

    public void mostrar(){
        System.out.println(cad);
    }


    // Método auxiliar para comprobar si un carácter es una vocal
    boolean esVocal(char ch){
        boolean esVocal = false;
        String vocales = "AEIOUÁÉÍÓÚÜaeiouáéíóúü";

        return vocales.indexOf(ch) != -1;
    }


    public static void main(String[] args) {
        Texto nombre = new Texto(5);

        nombre.add('Ó', true);
        nombre.add('s');
        nombre.add("car");

        nombre.mostrar();
        System.out.println(nombre);

        nombre.add(" Aguado");

        nombre.mostrar();
        System.out.println(nombre);        
    }

    
}