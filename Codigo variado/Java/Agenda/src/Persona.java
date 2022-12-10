
public class Persona {
    private String nombre;
    private String apellidos;
    private double peso;  // en kg
    private int estatura; // en cm
    private byte edad;
    private String dni;
    
    Persona (){
    }
    
    Persona (String nombre){
        this.nombre = nombre;
    }
    
    Persona (String nombre, String apellidos){
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public Persona(String nombre, String apellidos, double peso, int estatura, byte edad, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.peso = peso;
        this.estatura = estatura;
        this.edad = edad;
        this.dni = dni;
    }
    
    
    
    public void setPeso(double kg){
        if (kg < 0) 
            peso = 0;
        else
            peso = kg;
    }
    
    public double getPeso(){
        return peso;
    }

    public int getEstatura() {
        return estatura;
    }

    public void setEstatura(int estatura) {
        if (estatura < 0)
            this.estatura = 0;
        else
            this.estatura = estatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {        
        if (dniValido(dni))
            this.dni = dni;
    }
    
    public void mostrar(){
        System.out.println("PERSONA: " + nombre + " " +  apellidos + "(" + peso + "/" + estatura + ")");
    }
    
    public double imc(){
        return peso / Math.pow((estatura / 100.0),2);
    }
    
    public static boolean dniValido(String dni){               
        int longitud = dni.length();
        char letraDni = dni.charAt(longitud - 1);
        int numeroDni = Integer.parseInt(dni.substring(0, longitud - 1));
        
        char letraCorrecta = ' ';        
        
        switch (numeroDni % 23){
            case 0 -> letraCorrecta = 'T';
            case 1 -> letraCorrecta = 'R';
            case 2 -> letraCorrecta = 'W';
            case 3 -> letraCorrecta = 'A';
            case 4 -> letraCorrecta = 'G';
            case 5 -> letraCorrecta = 'M';
            case 6 -> letraCorrecta = 'Y';
            case 7 -> letraCorrecta = 'F';
            case 8 -> letraCorrecta = 'P';
            case 9 -> letraCorrecta = 'D';
            case 10 -> letraCorrecta = 'X';
            case 11 -> letraCorrecta = 'B';
            case 12 -> letraCorrecta = 'N';
            case 13 -> letraCorrecta = 'J';
            case 14 -> letraCorrecta = 'Z';
            case 15 -> letraCorrecta = 'S';
            case 16 -> letraCorrecta = 'Q';
            case 17 -> letraCorrecta = 'V';
            case 18 -> letraCorrecta = 'H';
            case 19 -> letraCorrecta = 'L';
            case 20 -> letraCorrecta = 'C';
            case 21 -> letraCorrecta = 'K';
            case 22 -> letraCorrecta = 'E';
        }        
        
        return letraCorrecta == letraDni;
    }
  
}
