class HolaMundo{
    public static void main (String[] args) {
        int numero;

        System.out.println("Hola, Mundo!");

        for(int i = 0; i < 100; i++) {
            numero = (int) (Math.random() * 6) + 1;
            System.out.println("Lanzamiento nº " + i + ": " + numero);
        }
            
    }
}
