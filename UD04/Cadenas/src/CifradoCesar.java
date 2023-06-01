import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * CifradoCesar
 */
public class CifradoCesar {

    public static void main(String[] args) {
        String str = "Óscar Núñez Aguado";
        String strCifrado = encriptarCesar(str, 1);
        String strDescifrado = desencriptarCesar(strCifrado, 1);

        System.out.println(str);
        System.out.println(strCifrado);
        System.out.println(strDescifrado);

    }

    public static String encriptarCesar(String cadena, int desplazamiento) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);

            if (Character.isLetter(caracter)) {
                // Obtener el valor numérico del caracter
                int valor = Character.toUpperCase(caracter) - 'A';

                // Aplicar el desplazamiento
                int nuevoValor = (valor + desplazamiento) % 26;

                if (nuevoValor < 0) {
                    // Asegurarse de que el valor esté dentro del rango [0, 25]
                    nuevoValor += 26;
                }

                // Convertir el valor de vuelta a un caracter
                char nuevoCaracter = (char) (nuevoValor + 'A');

                // Mantener el caso original
                if (Character.isLowerCase(caracter)) {
                    nuevoCaracter = Character.toLowerCase(nuevoCaracter);
                }

                resultado.append(nuevoCaracter);
            } else {
                // Mantener caracteres no alfabéticos
                resultado.append(caracter);
            }
        }

        return resultado.toString();
    }

    public static String desencriptarCesar(String cadena, int desplazamiento) {
        // Simplemente invertimos el desplazamiento para desencriptar
        int desplazamientoInverso = -desplazamiento;
        return encriptarCesar(cadena, desplazamientoInverso);
    }

    @Test
    public void pruebaEncriptarCesar() {
        String mensaje = "Hola, mundo!";
        int desplazamiento = 3;
        String mensajeEncriptado = CifradoCesar.encriptarCesar(mensaje, desplazamiento);
        assertEquals("Krod, pxqgr!", mensajeEncriptado);
    }

    @Test
    public void pruebaDesencriptarCesar() {
        String mensajeEncriptado = "Krod, pxqgr!";
        int desplazamiento = 3;
        String mensajeDesencriptado = CifradoCesar.desencriptarCesar(mensajeEncriptado, desplazamiento);
        assertEquals("Hola, mundo!", mensajeDesencriptado);
    }

    @Test
    public void pruebaDesplazamientoNegativo() {
        String mensaje = "Hola, mundo!";
        int desplazamiento = -3;
        String mensajeEncriptado = CifradoCesar.encriptarCesar(mensaje, desplazamiento);
        String mensajeDesencriptado = CifradoCesar.desencriptarCesar(mensajeEncriptado, desplazamiento);
        assertEquals(mensaje, mensajeDesencriptado);
    }

    @Test
    public void pruebaCadenaVacia() {
        String mensaje = "";
        int desplazamiento = 5;
        String mensajeEncriptado = CifradoCesar.encriptarCesar(mensaje, desplazamiento);
        assertEquals("", mensajeEncriptado);
    }

    @Test
    public void pruebaCaracteresNoAlfabeticos() {
        String mensaje = "123!@#$";
        int desplazamiento = 2;
        String mensajeEncriptado = CifradoCesar.encriptarCesar(mensaje, desplazamiento);
        String mensajeDesencriptado = CifradoCesar.desencriptarCesar(mensajeEncriptado, desplazamiento);
        assertEquals(mensaje, mensajeDesencriptado);
    }

}