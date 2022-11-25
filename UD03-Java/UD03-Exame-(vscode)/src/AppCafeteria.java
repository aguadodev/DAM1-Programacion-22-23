public class AppCafeteria {
    public static void main(String[] args) {
        Cafetera cafeteraBasica = new Cafetera();
        Cafetera cafeteraPequenha = new Cafetera(500);
        Cafetera cafeteraGrande = new Cafetera(2000, 1500);

        cafeteraBasica.mostrar();
        cafeteraBasica.llenarCafetera();
        cafeteraBasica.servirTaza(150);
        cafeteraBasica.mostrar();

        cafeteraPequenha.mostrar();
        for(int i = 0; i < 4; i++)
            cafeteraPequenha.servirTaza(150);
        cafeteraPequenha.mostrar();

        cafeteraGrande.mostrar();
        cafeteraGrande.vaciarCafetera();
        cafeteraGrande.agregarCafe(200);
        cafeteraGrande.mostrar();
        



        
    }
}
