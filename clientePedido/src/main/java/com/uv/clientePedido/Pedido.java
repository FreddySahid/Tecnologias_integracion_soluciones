package com.uv.clientePedido;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private int id;
    private LocalDate fecha;
    private float total;
    private int idProducto;
    private int idCliente;
    private int idPromocion;

    public Pedido(){

    }
    public void setId(int id){
        this.id=id;
    }
    public void setFecha(LocalDate fecha){
        this.fecha = fecha;
    }
    public void  setTotal(float total){
        this.total = total;
    }
    public void setIdProducto(int idProducto){
        this.idProducto = idProducto;
    }
    public void setIdCliente(int idCliente){
        this.idCliente=idCliente;
    }
    public void setIdPromocion(int idPromocion){
        this.idPromocion=idPromocion;
    }

    public int getId(){
        return id;
    }
    public LocalDate getFecha(){
        return fecha;
    }
    public float getTotal(){
        return total;
    }
    public int getIdProducto(){
        return idProducto;
    }
    public int getIdCliente(){
        return idCliente;
    }
    public int getIdPromocion(){
        return idPromocion;
    }

}
