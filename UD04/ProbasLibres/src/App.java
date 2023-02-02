import java.io.File;
import java.util.Scanner;

/**
Este proxecto l
 */
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("CICLOS DE INFORMÁTICA");
        System.out.println("Programacións de Probas Libres\n");
        
        String[][] modulos = {
            {"HARW",	"MP0371: Fundamentos de hardware"},
            {"ISO",	"MP0369: Implantación de sistemas operativos"},
            {"LMAR",	"MP0373: Linguaxes de marcas e sistemas de xestión de información"},
            {"RED",	"MP0370: Planificación e administración de redes"},
            {"XBD",	"MP0372: Xestión de bases de datos"},
            {"ASOP",	"MP0374: Administración de sistemas operativos"},
            {"IAWEB",	"MP0376: Implantación de aplicacións web"},
            {"SAD",	"MP0378: Seguridade e alta dispoñibilidade"},
            {"SRI",	"MP0375: Servizos de rede e internet"},
            {"SXBD",	"MP0377: Administración de sistemas xestores de bases de datos"},
            {"BD",	"MP0484: Bases de datos"},
            {"CDA",	"MP0487: Contornos de desenvolvemento"},
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
                System.out.println(listado[i]);
                String nomeModulo = getNomeProbaLibre(listado[i]);


                //ficheros[i].renameTo(ficheros[i].getPath());
                //System.out.println(ficheros[i].getPath());
                System.out.println(ficheros[i].getParent());
                String nombreFicheroDestino = ficheros[i].getPath() + "\\" + nomeModulo;
                System.out.println(nombreFicheroDestino);
                File f = new File(nombreFicheroDestino);
                System.out.println(f.getName());
                System.out.println(ficheros[i].renameTo(f));
                                
            }
        }
    }


    static String getNomeProbaLibre(String nombre){

        String[][] modulos = {
            {"HARW",	"MP0371: Fundamentos de hardware"},
            {"ISO",	"MP0369: Implantación de sistemas operativos"},
            {"LMAR",	"MP0373: Linguaxes de marcas e sistemas de xestión de información"},
            {"RED",	"MP0370: Planificación e administración de redes"},
            {"XBD",	"MP0372: Xestión de bases de datos"},
            {"ASOP",	"MP0374: Administración de sistemas operativos"},
            {"IAWEB",	"MP0376: Implantación de aplicacións web"},
            {"SAD",	"MP0378: Seguridade e alta dispoñibilidade"},
            {"SRI",	"MP0375: Servizos de rede e internet"},
            {"SXBD",	"MP0377: Administración de sistemas xestores de bases de datos"},
            {"BD",	"MP0484: Bases de datos"},
            {"CDA",	"MP0487: Contornos de desenvolvemento"},
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












    static String nomeProbaLibre(String codigoModulo){
        String nomeProbaLibre = null;

        String[][] modulos = {
            {"ASIR_PLIBRE_HARW",	"MP0371: Fundamentos de hardware"},
            {"ASIR_PLIBRE_ISO",	"MP0369: Implantación de sistemas operativos"},
            {"ASIR_PLIBRE_LMAR",	"MP0373: Linguaxes de marcas e sistemas de xestión de información"},
            {"ASIR_PLIBRE_RED",	"MP0370: Planificación e administración de redes"},
            {"ASIR_PLIBRE_XBD",	"MP0372: Xestión de bases de datos"},
            {"ASIR_PLIBRE_ASOP",	"MP0374: Administración de sistemas operativos"},
            {"ASIR_PLIBRE_IAWEB",	"MP0376: Implantación de aplicacións web"},
            {"ASIR_PLIBRE_SAD",	"MP0378: Seguridade e alta dispoñibilidade"},
            {"ASIR_PLIBRE_SRI",	"MP0375: Servizos de rede e internet"},
            {"ASIR_PLIBRE_SXBD",	"MP0377: Administración de sistemas xestores de bases de datos"},
            {"DAM_PLIBRE_BD",	"MP0484: Bases de datos"},
            {"DAM_PLIBRE_CDA",	"MP0487: Contornos de desenvolvemento"},
            {"DAM_PLIBRE_LMAR",	"MP0373: Linguaxes de marcas e sistemas de xestión de información"},
            {"DAM_PLIBRE_PROG",	"MP0485: Programación"},
            {"DAM_PLIBRE_SINF",	"MP0483: Sistemas informáticos"},
            {"DAM_PLIBRE_ADAT",	"MP0486: Acceso a datos"},
            {"DAM_PLIBRE_DINT",	"MP0488: Desenvolvemento de interfaces"},
            {"DAM_PLIBRE_PMUL",	"MP0489: Programación multimedia e dispositivos móbiles"},
            {"DAM_PLIBRE_PSER",	"MP0490: Programación de servizos e procesos"},
            {"DAM_PLIBRE_SXE",	"MP0491: Sistemas de xestión empresarial"},
            {"DAM_PLIBRE_BD",	"MP0484: Bases de datos"},
            {"DAM_PLIBRE_CDA",	"MP0487: Contornos de desenvolvemento"},
            {"DAM_PLIBRE_LMAR",	"MP0373: Linguaxes de marcas e sistemas de xestión de información"},
            {"DAM_PLIBRE_PROG",	"MP0485: Programación"},
            {"DAM_PLIBRE_SINF",	"MP0483: Sistemas informáticos"},
            {"DAW_PLIBRE_BD",	"MP0484: Bases de datos"},
            {"DAW_PLIBRE_CD",	"MP0487: Contornos de desenvolvemento"},
            {"DAW_PLIBRE_DAW",	"MP0614: Despregamento de aplicacións web"},
            {"DAW_PLIBRE_DIW",	"MP0615: Deseño de interfaces web"},
            {"DAW_PLIBRE_DWCC",	"MP0612: Desenvolvemento web en contorno cliente"},
            {"DAW_PLIBRE_DWCS",	"MP0613: Desenvolvemento web en contorno servidor"},
            {"DAW_PLIBRE_LMAR",	"MP0373: Linguaxes de marcas e sistemas de xestión de información"},
            {"DAW_PLIBRE_PROG",	"MP0485: Programación"},
            {"DAW_PLIBRE_SINF",	"MP0483: Sistemas informáticos"},
            {"FPB1_PLIBRE_MMSI",	"MP3029: Montaxe e mantemento de sistemas e compoñentes informáticos"},
            {"FPB1_PLIBRE_OFI",	"MP3031: Ofimática e arquivamento de documentos"},
            {"FPB2_PLIBRE_IMRED",	"MP3016: Instalación e mantemento de redes para transmisión de datos"},
            {"FPB2_PLIBRE_OAUX",	"MP3030: Operacións auxiliares para a configuración e a explotación"},
            {"SMR_PLIBRE_AO",	"MP0223: Aplicacións ofimáticas"},
            {"SMR_PLIBRE_MME",	"MP0221: Montaxe e mantemento de equipamentos"},
            {"SMR_PLIBRE_REDES",	"MP0225: Redes locais"},
            {"SMR_PLIBRE_SOM",	"MP0222: Sistemas operativos monoposto"},
            {"SMR_PLIBRE_AWEB",	"MP0228: Aplicacións web"},
            {"SMR_PLIBRE_SER",	"MP0227: Servizos en rede"},
            {"SMR_PLIBRE_SI",	"MP0226: Seguridade informática"},
            {"SMR_PLIBRE_SOR",	"MP0224: Sistemas operativos en rede"},
            {"SMR_PLIBRE_AO",	"MP0223: Aplicacións ofimáticas"},
            {"SMR_PLIBRE_AWEB",	"MP0228: Aplicacións web"},
            {"SMR_PLIBRE_MME",	"MP0221: Montaxe e mantemento de equipamentos"},
            {"SMR_PLIBRE_REDES",	"MP0225: Redes locais"},
            {"SMR_PLIBRE_SER",	"MP0227: Servizos en rede"},
            {"SMR_PLIBRE_SI",	"MP0226: Seguridade informática"},
            {"SMR_PLIBRE_SOM",	"MP0222: Sistemas operativos monoposto"},
            {"SMR_PLIBRE_SOR",	"MP0224: Sistemas operativos en rede"}
            };


        String[] nomesProbaLibre = {
            "ASIR_PLIBRE_HARW",
            "ASIR_PLIBRE_ISO",
            "ASIR_PLIBRE_LMAR",
            "ASIR_PLIBRE_RED",
            "ASIR_PLIBRE_XBD",
            "ASIR_PLIBRE_ASOP",
            "ASIR_PLIBRE_IAWEB",
            "ASIR_PLIBRE_SAD",
            "ASIR_PLIBRE_SRI",
            "ASIR_PLIBRE_SXBD",
            "DAM_PLIBRE_BD",
            "DAM_PLIBRE_CDA",
            "DAM_PLIBRE_LMAR",
            "DAM_PLIBRE_PROG",
            "DAM_PLIBRE_SINF",
            "DAM_PLIBRE_ADAT",
            "DAM_PLIBRE_DINT",
            "DAM_PLIBRE_PMUL",
            "DAM_PLIBRE_PSER",
            "DAM_PLIBRE_SXE",
            "DAM_PLIBRE_BD",
            "DAM_PLIBRE_CDA",
            "DAM_PLIBRE_LMAR",
            "DAM_PLIBRE_PROG",
            "DAM_PLIBRE_SINF",
            "DAW_PLIBRE_BD",
            "DAW_PLIBRE_CD",
            "DAW_PLIBRE_DAW",
            "DAW_PLIBRE_DIW",
            "DAW_PLIBRE_DWCC",
            "DAW_PLIBRE_DWCS",
            "DAW_PLIBRE_LMAR",
            "DAW_PLIBRE_PROG",
            "DAW_PLIBRE_SINF",
            "FPB1_PLIBRE_MMSI",
            "FPB1_PLIBRE_OFI",
            "FPB2_PLIBRE_IMRED",
            "FPB2_PLIBRE_OAUX",
            "SMR_PLIBRE_AO",
            "SMR_PLIBRE_MME",
            "SMR_PLIBRE_REDES",
            "SMR_PLIBRE_SOM",
            "SMR_PLIBRE_AWEB",
            "SMR_PLIBRE_SER",
            "SMR_PLIBRE_SI",
            "SMR_PLIBRE_SOR",
            "SMR_PLIBRE_AO",
            "SMR_PLIBRE_AWEB",
            "SMR_PLIBRE_MME",
            "SMR_PLIBRE_REDES",
            "SMR_PLIBRE_SER",
            "SMR_PLIBRE_SI",
            "SMR_PLIBRE_SOM",
            "SMR_PLIBRE_SOR"           
        };


        
        return nomeProbaLibre;
    }

}
