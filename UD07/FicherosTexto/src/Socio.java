import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "socio")
@XmlType(propOrder = { "nombre", "direccion", "fechaAlta" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Socio {
    @XmlAttribute(name = "id", required = true)
    private Integer id;
    @XmlAttribute(name = "nombre")
    private String nombre;
    private String direccion;
    @XmlAttribute(name = "alta")
    private String fechaAlta;

    public Socio() {
    }

    public Socio(Integer id, String nombre, String direccion, String fechaAlta) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaAlta = fechaAlta;
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

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @Override
    public String toString() {
        return "Socio [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", fechaAlta=" + fechaAlta + "]";
    }

    public static void main(String[] args) {
        JAXBContext contexto;
        try {
            contexto = JAXBContext.newInstance(Socio.class);
            Unmarshaller um = contexto.createUnmarshaller();
            Socio s = (Socio) um.unmarshal(new File("socio.xml"));
            System.out.println(s);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

}
