package horas;
public class Hora {
    int hora;
    int minuto;

    public Hora(int hora, int minuto) {        
        this.hora = hora >= 0 && hora < 24 ? hora : 0;
        this.minuto = minuto >= 0 && minuto < 60 ? minuto : 0;
    }

    public void inc(){
        minuto++;
        if (minuto == 60){
            minuto = 0;
            hora++;
            if (hora == 24)
                hora = 0;
        }
    }

    public boolean setHora(int hora) {
        boolean horaValida = hora >= 0 && hora < 24;
        if (horaValida)
            this.hora = hora;
        
        return horaValida;
    }

    public boolean setMinuto(int minuto) {
        boolean minValido = minuto >= 0 && minuto < 60;
        if (minValido)
            this.minuto = minuto;
        
        return minValido;        
    }

    @Override
    public String toString() {
        String str = "";
        if (hora < 10)
            str += "0";
        str += hora + ":";

        if (minuto < 10)
            str += "0";
        
        str += minuto;

        return str;
    }

    public static void main(String[] args) {
        Hora hora1 = new Hora(23,59);
        Hora hora2 = new Hora(3,59);
        Hora hora3 = new Hora(23,9);
        Hora hora4 = new Hora(3,9);

        System.out.println(hora1);
        System.out.println(hora2);
        System.out.println(hora3);
        System.out.println(hora4);

    }


    
}
