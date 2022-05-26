package mx.uv.pedidocliente.pedidocliente;

//import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;



@RestController
public class pedidoClienteControlador {
    @Autowired
    private Icliente icliente;
    @Autowired
    private Ipedido ipedido;

    @RequestMapping(value = "/crearCliente/{nombre}/{domicilio}/{ciudad}/{telefono}", method = RequestMethod.POST)
    public String crearCliente(@PathVariable(("nombre")) String nombre,
            @PathVariable(("domicilio")) String domicilio, @PathVariable(("ciudad")) String ciudad, 
            @PathVariable(("telefono")) long telefono) {
                
        Cliente cliente = new Cliente();
        String mensaje = "";

       
        
       
        cliente.setNombre(nombre);
        cliente.setDomicilio(domicilio);
        cliente.setCiudad(ciudad);
        cliente.setTelefono(telefono);

        icliente.save(cliente);

        if( icliente.save(cliente)==null){
            mensaje = "Algo a salido mal, información no guardada";

        }else{
            mensaje ="Información del cliente registrada";

        }
        return mensaje;
    }

    
    @RequestMapping(value = "/obtenerclientes", method = RequestMethod.GET)
    public Iterable<Cliente> obtenerclientes() {
        return icliente.findAll();
    }

    @RequestMapping(value = "/eliminarcliente/{id}", method = RequestMethod.DELETE)
    public boolean eliminarcliente(@PathVariable() int id) {
        icliente.deleteById(id);
        return true;
    }

    @RequestMapping(value = "/crearpedido/{total}/{idProducto}/{idPromocion}", method = RequestMethod.POST)
    public String crearpedido(@PathVariable(("total")) float total,
            @PathVariable(("idProducto")) int idProducto, @PathVariable(("idPromocion")) int idPromocion) {
        Pedido pedido = new Pedido();        
        String mensaje = "";

        LocalDate todaysDate = LocalDate.now();

        pedido.setFecha(todaysDate);
        pedido.setTotal(total);
        pedido.setIdProducto(idProducto);
        pedido.setIdPromocion(idPromocion);
        
        ipedido.save(pedido);

        if( ipedido.save(pedido)==null){
            mensaje = "Algo a salido mal, información no guardada";

        }else{
            mensaje ="Información del pedido registrada";

        }
        return mensaje;
    }

    @RequestMapping(value = "/obtenerPedidos", method = RequestMethod.GET)
    public Iterable<Pedido> obtenerPedidos() {
        return ipedido.findAll();
    }

}
