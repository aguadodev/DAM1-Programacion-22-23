import java.util.Scanner;

public class Ud02Ex03Radar {
    public static void main(String[] args) {
        final int DISTANCIA = 10;
        final int LIMITE_VELOCIDADE = 120;

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el tiempo en segundos:");
        int segundos = sc.nextInt();
        double exceso = excesoVelocidade(DISTANCIA, segundos, LIMITE_VELOCIDADE);
        System.out.println(exceso);
        if (exceso > 0) {
            System.out.println("Infracción por exceso de velocidade!! Multa de "+
            multaInfraccion(LIMITE_VELOCIDADE, exceso) + " €!!");
        } else {
            System.out.println("Velocidade dentro do límite");
        }



/*
        System.out.println(excesoVelocidade(10, 600, 60));
        System.out.println(excesoVelocidade(10, 600, 50));
        System.out.println(excesoVelocidade(10, 600, 30));
        System.out.println(excesoVelocidade(15, 300, 120));
        System.out.println(excesoVelocidade(15, 300, 90));
        System.out.println(excesoVelocidade(10, 300, 120));
        System.out.println(excesoVelocidade(10, 300, 90));

        System.out.println("PRUEBAS MULTAS");
        System.out.println(multaInfraccion(20, 0));
        System.out.println(multaInfraccion(20, 15));
        System.out.println(multaInfraccion(30, 21));
        System.out.println(multaInfraccion(40, 31));
        System.out.println(multaInfraccion(50, 50));
        System.out.println(multaInfraccion(50, 51));

        System.out.println(multaInfraccion(60, 0));
        System.out.println(multaInfraccion(70, 30));
        System.out.println(multaInfraccion(80, 31));
        System.out.println(multaInfraccion(90, 51));
        System.out.println(multaInfraccion(100, 61));
        System.out.println(multaInfraccion(110, 71));
        System.out.println(multaInfraccion(120, 1));*/

    }

    public static double excesoVelocidade(double distancia, int tempo, int limite){
        double exceso = distancia / (tempo / 3600.0) - limite;

        return exceso > 0? exceso:0;
    }


    public static int multaInfraccion(int limite, double excesoVelocidade) {
        int multa = 0;
        if (excesoVelocidade <= 0)
            multa = 0;
        else 
            if (limite <= 50) {
                if (excesoVelocidade <= 20)
                    multa = 100;
                else if (excesoVelocidade <= 30)
                    multa = 300;
                else if (excesoVelocidade <= 40)
                    multa = 400;
                else if (excesoVelocidade <= 50)
                    multa = 500;
                else
                    multa = 600;
            }
            else {
                if (excesoVelocidade <= 30)
                    multa = 100;
                else if (excesoVelocidade <= 50)
                    multa = 300;
                else if (excesoVelocidade <= 60)
                    multa = 400;
                else if (excesoVelocidade <= 70)
                    multa = 500;
                else
                    multa = 600;
            }
        return multa;
    }



}
