import java.io.File;
import java.util.Scanner;

/**
Este programa modifica os nomes dos ficheiro pdf de programacións libres dos módulos de informática almacenados
nun directorio dado aos nomes de ficheiro solicitados pola xefatura de estudos: CICLO_PLIBRE_MODULO.
 */
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("CICLOS DE INFORMÁTICA");
        System.out.println("Programacións de Probas Libres\n");

        String sCarpAct = null; // Z:\0.DEPTO\13. Probas Libres\Programacions 22-23
        if (args == null || args.length == 0) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Ruta del directorio a examinar ('ENTER' para el directorio actual): ");
            sCarpAct = sc.nextLine();
            if (sCarpAct == null || sCarpAct.length() == 0)
                sCarpAct = System.getProperty("user.dir");
                sCarpAct = "G:\\Mi unidad\\D.Departamento\\0. Curso 22-23\\13. Probas Libres\\Programacions 22-23";
        }
        
        File carpeta = new File(sCarpAct);

        String[] listado = carpeta.list();        

        if (listado == null || listado.length == 0) {
            System.out.println("No hay elementos dentro de la carpeta actual");
            return;
        }
        else {
            
            File[] ficheros = carpeta.listFiles();

            // Busca el fichero en la lista de módulos.
            for (int i = 0; i < listado.length; i++) {                
                //System.out.println(listado[i]);
                String nomeModulo = getNomeProbaLibre(listado[i]);


                //ficheros[i].renameTo(ficheros[i].getPath());
                //System.out.println(ficheros[i].getPath());
                //System.out.println("getParent() - " + ficheros[i].getParent());
                String nombreFicheroDestino = ficheros[i].getParent() + "\\" + nomeModulo + ".pdf";
                File f = new File(nombreFicheroDestino);
                //System.out.println("nombreFicheroDestino - " + nombreFicheroDestino);
                //System.out.println("getName() - " + f.getName());
                System.out.println("renameTo(f) - " + ficheros[i].renameTo(f));
                System.out.println("\n");
                                
            }
        }
    }


    static String getNomeProbaLibre(String nombre){

        String[][] modulos = {
            {"FHW",	"MP0371: Fundamentos de hardware"},
            {"ISO",	"MP0369: Implantación de sistemas operativos"},
            {"LMAR",	"MP0373: Linguaxes de marcas e sistemas de xestión de información"},
            {"PAR",	"MP0370: Planificación e administración de redes"},
            {"XBD",	"MP0372: Xestión de bases de datos"},
            {"ASOP",	"MP0374: Administración de sistemas operativos"},
            {"IAWEB",	"MP0376: Implantación de aplicacións web"},
            {"SAD",	"MP0378: Seguridade e alta dispoñibilidade"},
            {"SRI",	"MP0375: Servizos de rede e internet"},
            {"ASXBD",	"MP0377: Administración de sistemas xestores de bases de datos"},
            {"BD",	"MP0484: Bases de datos"},
            {"CD",	"MP0487: Contornos de desenvolvemento"},
            {"PROG",	"MP0485: Programación"},
            {"SINF",	"MP0483: Sistemas informáticos"},
            {"ADAT",	"MP0486: Acceso a datos"},
            {"DINT",	"MP0488: Desenvolvemento de interfaces"},
            {"PMUL",	"MP0489: Programación multimedia e dispositivos móbiles"},
            {"PSER",	"MP0490: Programación de servizos e procesos"},
            {"SXE",	"MP0491: Sistemas de xestión empresarial"},
            {"DAW",	"MP0614: Despregamento de aplicacións web"},
            {"DIW",	"MP0615: Deseño de interfaces web"},
            {"DWCC",	"MP0612: Desenvolvemento web en contorno cliente"},
            {"DWCS",	"MP0613: Desenvolvemento web en contorno servidor"},
            {"FPB1_PLIBRE_MMSI",	"MP3029: Montaxe e mantemento de sistemas e compoñentes informáticos"},
            {"FPB1_PLIBRE_OFI",	"MP3031: Ofimática e arquivamento de documentos"},
            {"FPB2_PLIBRE_IMRED",	"MP3016: Instalación e mantemento de redes para transmisión de datos"},
            {"FPB2_PLIBRE_OAUX",	"MP3030: Operacións auxiliares para a configuración e a explotación"},
            {"AO",	"MP0223: Aplicacións ofimáticas"},
            {"MME",	"MP0221: Montaxe e mantemento de equipamentos"},
            {"REDES",	"MP0225: Redes locais"},
            {"SOM",	"MP0222: Sistemas operativos monoposto"},
            {"AWEB",	"MP0228: Aplicacións web"},
            {"SER",	"MP0227: Servizos en rede"},
            {"SI",	"MP0226: Seguridade informática"},
            {"SOR",	"MP0224: Sistemas operativos en rede"}
        };

        int i = 0;
        while (i < modulos.length && !nombre.contains(modulos[i][1].substring(0,6)))
            i++;

        if (i == modulos.length)
            return null;
        else             
            if (nombre.contains("CMIFC01"))
                return "SMR_PLIBRE_" + modulos[i][0];
            else if (nombre.contains("CSIFC01"))
                return "ASIR_PLIBRE_" + modulos[i][0];                
            else if (nombre.contains("CSIFC02"))
                return "DAM_PLIBRE_" + modulos[i][0];                
            else if (nombre.contains("CSIFC03"))
                return "DAW_PLIBRE_" + modulos[i][0];                
            else
                return null;            
    
    }
}