package com.uv.clientePedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.time.LocalDate;


public class EndPonitClientePedido {
    @Autowired
    private Icliente icliente;
    private Ipedido ipedido;
    

    @RequestMapping(value = "/GuardarCliente/{nombreCliente}/{domicilio}/{ciudad}/{telefono}", method = RequestMethod.POST)
    public String GuardarCliente(@PathVariable("nombreCliente") String nombreC, @PathVariable("domicilio") String domicilio,
    @PathVariable("ciudad") String ciudad, @PathVariable("telefono") long telefono)
    {
            if(nombreC != null || domicilio != null || ciudad != null || telefono != 0){
                Cliente cliente = new Cliente();
                cliente.setNombre(nombreC);
                cliente.setDomicilio(domicilio);
                cliente.setCiudad(ciudad);
                cliente.setTelefono(telefono);
                icliente.save(cliente);
                return "Cliente agregado";
            }else{
                return "Ha ocurrido un problema, no se pudo agregar el cliente ";
            }        
    }
    @DeleteMapping(path ="BorrarCliente/{id}" )
    public Boolean BorrarCliente(@PathVariable("id") int clienteID) {
        try{
            icliente.deleteById(clienteID);
            return true;
        }catch(Exception e){
            return false;

        }          
    }

    @RequestMapping(value = "/GernerarPedido/{total}/{idProducto}/{idCliente}/{idPromocion}", method = RequestMethod.POST)
    public String GernerarPedido( @PathVariable("total") float total,
    @PathVariable("idProducto") int idProducto, @PathVariable("idCliente") int idCliente, @PathVariable("idPromocion") int idPromocion)
    {
        if(total != 0 || idProducto != 0 || idCliente != 0 || idPromocion != 0){

            LocalDate todaysDate = LocalDate.now();
                
            Pedido pedido = new Pedido();
            pedido.setFecha(todaysDate);
            pedido.setTotal(total);
            pedido.setIdProducto(idProducto);
            pedido.setIdCliente(idCliente);
            pedido.setIdPromocion(idPromocion);
            ipedido.save(pedido);
            return "Pedido generado";
        }else{
            return "Ha ocurrido un problema, no se pudo generar el pedido";
        }        
    }






}
