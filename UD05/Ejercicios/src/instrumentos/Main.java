package instrumentos;

import instrumentos.Instrumento.NotaMusical;

public class Main {
    public static void main(String[] args) {
        String[] melodia = {"LA", "RE", "MI"};

        Piano piano = new Piano(melodia);
        Guitarra guitarraRitmica = new Guitarra(melodia);  
        Guitarra guitarraRitmica2 = new Guitarra(melodia);  
        Campana campana = new Campana();
        campana.add(NotaMusical.valueOf("FA"));

        Guitarra guitarraSolista = new Guitarra();
        guitarraSolista.add(NotaMusical.valueOf("FA"));
        guitarraSolista.add(NotaMusical.valueOf("SOL"));
        guitarraSolista.add(NotaMusical.valueOf("DO"));        

        Instrumento[] orquesta = new Instrumento[4];
        orquesta[0] = piano;
        orquesta[1] = guitarraRitmica;
        orquesta[2] = guitarraSolista;
        orquesta[3] = campana;

        for(Instrumento i: orquesta){
            i.interpretar();
        }

        System.out.println(guitarraRitmica.equals(guitarraRitmica2)); // True

    }
}
