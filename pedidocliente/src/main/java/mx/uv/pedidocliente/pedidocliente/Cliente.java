package mx.uv.pedidocliente.pedidocliente;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private String domicilio;
    private String ciudad;
    private long telefono;

    public Cliente(){

    }

    public void setId(int id){
        this.id = id;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setDomicilio(String domicilio){
        this.domicilio=domicilio;
    }
    public void setCiudad(String ciudad){
        this.ciudad = ciudad;
    }
    public void setTelefono(long telefono){
        this.telefono=telefono;
    }

    public int getId(){
        return id; 
    }
    public String getNombre(){
        return nombre;
    }
    public String getDomicilio(){
        return domicilio;
    }
    public String getCiudad(){
        return ciudad;
    }
    public long getTelefona(){
        return telefono;
    }



}