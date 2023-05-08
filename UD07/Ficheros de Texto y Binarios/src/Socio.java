import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;

/**
 * Clase Socio de ejemplo para cargar objetos desde un archivo XML ("src/socio.xml")
 * Incluye programa principal en main()
 */

@XmlRootElement(name = "socio")
@XmlType(propOrder = { "nombre", "direccion", "alta" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Socio {
    @XmlAttribute(name = "id", required = true)
    private Integer id;
    private String nombre;
    private String direccion;
    private String alta;

    public Socio() {
    }

    public Socio(Integer id, String nombre, String direccion, String alta) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.alta = alta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getalta() {
        return alta;
    }

    public void setalta(String alta) {
        this.alta = alta;
    }

    @Override
    public String toString() {
        return "Socio [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", alta=" + alta + "]";
    }

    public static void main(String[] args) {
        JAXBContext contexto;
        try {
            contexto = JAXBContext.newInstance(Socio.class);
            Unmarshaller um = contexto.createUnmarshaller();
            Socio s = (Socio) um.unmarshal(new File("src/socio.xml"));
            System.out.println(s);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

}
