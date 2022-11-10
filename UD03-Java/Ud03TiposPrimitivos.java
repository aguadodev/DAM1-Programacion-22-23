import java.math.BigDecimal;

public class Ud03TiposPrimitivos {
    public static void main(String[] args) {
        // Declaración de variables
        byte varByte;
        short varShort;
        int varInt; 
        long varLong;
        float varFloat;
        double varDouble;
        boolean varBoolean;
        char varChar;

        // Inicialización de variables
        varByte = 127;
        varShort = 32767;
        varInt = 2147483647; 
        varLong = 2147483648L;
        varFloat = 2.456456546F;
        varDouble = 2.456456546;
        varBoolean = false;
        varChar = 'A';

        System.out.println("La variable varByte tiene el valor " + varByte);
        System.out.println("La variable varShort tiene el valor " + varShort);
        System.out.println("La variable varInt tiene el valor " + varInt);
        System.out.println("La variable varLong tiene el valor " + varLong);
        System.out.println("La variable varFloat tiene el valor " + varFloat);
        System.out.println("La variable varDouble tiene el valor " + varDouble);
        System.out.println("La variable varBoolean tiene el valor " + varBoolean);
        System.out.println("La variable varChar tiene el valor " + varChar);

        System.out.println("IMPRIMIENDO VARIABLES INCREMENTADAS EN 1 (++)");
        varByte++;
        varShort++;
        varInt++; 
        varLong++;
        varFloat++;
        varDouble++;
        varChar++;
        System.out.println("La variable varByte++ " + varByte);
        System.out.println("La variable varShort++ " + varShort);
        System.out.println("La variable varInt++ " + varInt);
        System.out.println("La variable varLong++ " + varLong);
        System.out.println("La variable varFloat++ " + varFloat);
        System.out.println("La variable varDouble++ " + varDouble);
        System.out.println("La variable varBoolean no se puede incrementar.");
        System.out.println("La variable varChar++ " + varChar);        

        System.out.println("PROBLEMAS DE PRECISIÓN");
        double unCentimo = 0.01;
        double suma = unCentimo + unCentimo + unCentimo + unCentimo + unCentimo + unCentimo;
        System.out.println("Suma de 6 céntimos: " + suma);
        System.out.println("SOLUCIÓN CON LA CLASE BigDecimal");

        BigDecimal unCentimoPreciso, sumaPrecisa;
        unCentimoPreciso = BigDecimal.valueOf(0.01);
        sumaPrecisa = new BigDecimal(0);
        sumaPrecisa = sumaPrecisa.add(unCentimoPreciso).add(unCentimoPreciso).add(unCentimoPreciso);
        sumaPrecisa = sumaPrecisa.add(unCentimoPreciso).add(unCentimoPreciso).add(unCentimoPreciso);
        System.out.println(sumaPrecisa);



    }
}
