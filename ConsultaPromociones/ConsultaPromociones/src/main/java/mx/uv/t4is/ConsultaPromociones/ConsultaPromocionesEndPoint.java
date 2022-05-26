package mx.uv.t4is.ConsultaPromociones;

//import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.consultapromociones.ActualizarPromocionRequest;
import https.t4is_uv_mx.consultapromociones.ActualizarPromocionResponse;
import https.t4is_uv_mx.consultapromociones.EliminarPromocionRequest;
import https.t4is_uv_mx.consultapromociones.EliminarPromocionResponse;
import https.t4is_uv_mx.consultapromociones.MostrarPromocionResponse;
import https.t4is_uv_mx.consultapromociones.RegistrarPromocionRequest;
import https.t4is_uv_mx.consultapromociones.RegistrarPromocionResponse;

//import https.t4is_uv_mx.saludos.BuscarSaludosResponse.Saludos;



@Endpoint
public class ConsultaPromocionesEndPoint{
   
    //private int value=1;
    //ArrayList<Saludos> lista = new ArrayList<>();
    @Autowired
    IConsultaPromociones agregarbd;

    @PayloadRoot(localPart = "registrarPromocionRequest", namespace = "https://t4is.uv.mx/ConsultaPromociones")
    @ResponsePayload
    public RegistrarPromocionResponse RegistrarPromocion(@RequestPayload RegistrarPromocionRequest peticion) {
        RegistrarPromocionResponse respuesta = new RegistrarPromocionResponse();
        //se agrega a la a la base de datos
        ConsultaPromociones consultar = new ConsultaPromociones();
        respuesta.setRespuesta("OK, Se registro la promoción "+ peticion.getNombre()+" actualizado en: "+peticion.getDia());
        //consultar.setNombre(peticion.getNombre());
        consultar.setNombre(peticion.getNombre());
        consultar.setDia(peticion.getDia());
        consultar.setPrecio(peticion.getPrecio());
        //
        agregarbd.save(consultar);
        //lista.add(e);
        return respuesta;
        
    }

   
    @PayloadRoot(localPart = "mostrarPromocionRequest", namespace = "https://t4is.uv.mx/ConsultaPromociones")
    @ResponsePayload
    public MostrarPromocionResponse mostrarPromociones(){
        MostrarPromocionResponse respuesta = new MostrarPromocionResponse();
       Iterable<ConsultaPromociones> lista = agregarbd.findAll();
        //recorrer la lista
        //Iterable<>
        for (ConsultaPromociones a : lista) {
            //System.out.println(rLista);
            MostrarPromocionResponse.Consulta e = new MostrarPromocionResponse.Consulta();
            //e.setNombre(a.getNombre());
            //e.setId(o.getId());
            e.setNombre(a.getNombre());
            e.setId(a.getId());
            e.setDia(a.getDia());
            e.setPrecio(a.getPrecio());
            //respuesta.getSaludos().add(e);
            respuesta.getConsulta().add(e);
            
        }
        return respuesta;
    }

    @PayloadRoot(localPart = "actualizarPromocionRequest", namespace = "https://t4is.uv.mx/ConsultaPromociones")
    @ResponsePayload
    public ActualizarPromocionResponse actualizarPromocion(@RequestPayload ActualizarPromocionRequest peticion){
        ActualizarPromocionResponse respuesta = new ActualizarPromocionResponse();
        //recorrer la lista
        ConsultaPromociones element = new ConsultaPromociones();
        element.setId(peticion.getId());
        element.setNombre(peticion.getNombre());
        element.setDia(peticion.getDia());
        element.setPrecio(peticion.getPrecio());
        agregarbd.save(element);
        //lista.set(peticion.getId()-1,element);
        respuesta.setRespuesta(true);
        return respuesta;
    }

    @PayloadRoot(localPart = "eliminarPromocionRequest", namespace = "https://t4is.uv.mx/ConsultaPromociones")
    @ResponsePayload
    public EliminarPromocionResponse eliminarPromocion(@RequestPayload EliminarPromocionRequest peticion){
        EliminarPromocionResponse respuesta = new EliminarPromocionResponse();
       
        agregarbd.deleteById(peticion.getId());
        //agregarbd.deleteById(peticion.getNombre());     
        respuesta.setRespuesta(true);
        return respuesta;
    }


    
}