package mx.uv.t4is.ConsultaPromociones;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ConsultaPromociones {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

   private int id;
   private String nombre;
   private String dia;
   private float precio;

   public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}

public String getNombre() {
    return nombre;
}
public float getPrecio() {
    return precio;
}
public void setPrecio(float f) {
    this.precio = f;
}
public String getDia() {
    return dia;
}
public void setDia(String dia) {
    this.dia = dia;
}
public void setNombre(String nombre) {
    this.nombre = nombre;
}
    
}
