package mx.uv.Productos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.uv_mx.productos.ProductoResponse;
import https.uv_mx.productos.RegistrarProductoRequest;
import https.uv_mx.productos.MostrarProductosResponse;
import https.uv_mx.productos.ModificarProductoRequest;
import https.uv_mx.productos.ModificarProductoResponse;

import https.uv_mx.productos.BorrarProductoRequest;
import https.uv_mx.productos.BorrarProductoResponse;

@Endpoint
public class ProductoEndPoint {
    @Autowired
    Iproductos iproductos;

    @PayloadRoot(localPart = "RegistrarProductoRequest", namespace = "https://uv.mx/productos")
    @ResponsePayload
    public ProductoResponse  RegistrarProducto(@RequestPayload RegistrarProductoRequest peticion){

        ProductoResponse respuesta = new ProductoResponse();
        respuesta.setRespuesta(peticion.getTipo());

        Producto producto = new Producto();
        producto.setTipo(peticion.getTipo());
        producto.setDescripcion(peticion.getDescripcion());
        producto.setPrecio(peticion.getPrecio());
        
        iproductos.save(producto);
        return respuesta;
    }

    @PayloadRoot(localPart = "MostrarProductosRequest",namespace = "https://uv.mx/productos")
    @ResponsePayload
    public MostrarProductosResponse MostrarProductos(){
        MostrarProductosResponse respuesta = new MostrarProductosResponse();
        Iterable<Producto> lista = iproductos.findAll();
        for (Producto o : lista) {
            MostrarProductosResponse.Productos mostrarProducto = new MostrarProductosResponse.Productos();
            mostrarProducto.setId(o.getId());
            mostrarProducto.setTipo(o.getTipo());
            mostrarProducto.setDescripcion(o.getDescripcion());
            mostrarProducto.setPrecio(o.getPrecio());
            
            respuesta.getProductos().add(mostrarProducto);
            
            
        }
        return respuesta;
    }

    @PayloadRoot(localPart = "ModificarProductoRequest",namespace = "https://uv.mx/productos")
    @ResponsePayload
    public ModificarProductoResponse ModificarProducto(@RequestPayload ModificarProductoRequest peticion){
        ModificarProductoResponse respuesta = new ModificarProductoResponse();
        Producto e = new Producto();

        e.setId(peticion.getId());
        e.setTipo(peticion.getTipo());
        e.setDescripcion(peticion.getDescripcion());
        e.setPrecio(peticion.getPrecio());
        iproductos.save(e);
        respuesta.setRespuesta(true);
        return respuesta;
    }

    @PayloadRoot(localPart = "BorrarProductoRequest",namespace = "https://uv.mx/productos")
    @ResponsePayload
    public BorrarProductoResponse BorrarProducto(@RequestPayload BorrarProductoRequest peticion){
        BorrarProductoResponse respuesta = new BorrarProductoResponse();
      
        iproductos.deleteById(peticion.getId());
        respuesta.setRespuesta(true);
        return respuesta;
    }
    
}
