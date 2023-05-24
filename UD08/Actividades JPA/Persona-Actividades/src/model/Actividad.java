package model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Actividad {
    @Id
    int id;
    String titulo;
    String descripcion;
    LocalDateTime fechaHoraInicio;
    LocalDateTime fechaHoraFin;
    String lugar; // TODO: cambiar a coordenadas GMaps?
    Usuario organizador;
    int plazas;
    List<Usuario> participantes;


    
    public Actividad() {
    }



    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public String getTitulo() {
        return titulo;
    }



    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }



    public String getDescripcion() {
        return descripcion;
    }



    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }



    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }



    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }



    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }



    public String getLugar() {
        return lugar;
    }



    public void setLugar(String lugar) {
        this.lugar = lugar;
    }



    public Usuario getOrganizador() {
        return organizador;
    }



    public void setOrganizador(Usuario organizador) {
        this.organizador = organizador;
    }



    public int getPlazas() {
        return plazas;
    }



    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }



    public List<Usuario> getParticipantes() {
        return participantes;
    }



    public void setParticipantes(List<Usuario> participantes) {
        this.participantes = participantes;
    }
    
    

}
