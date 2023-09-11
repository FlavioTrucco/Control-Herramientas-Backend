package com.gestion.empleados.inventario_backend.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.empleados.inventario_backend.Exception.ResourceNotFoundException;
import com.gestion.empleados.inventario_backend.Repositories.HerramientaRepository;
import com.gestion.empleados.inventario_backend.Repositories.RegistroRepository;
import com.gestion.empleados.inventario_backend.models.Herramienta;
import com.gestion.empleados.inventario_backend.models.Registro;



@RestController
@RequestMapping("/api/v1/")
@CrossOrigin (origins ="http://localhost:4200")

public class RegistroControlador{

    @Autowired
    private RegistroRepository registrorepository;

    // este metodo sirve para listar todos los registro
    @GetMapping("/altas-bajas")
    public List<Registro> listarTodasLosRegistros() {
        return registrorepository.findAll();
    }

    @PostMapping("/altas-bajas")
    public Registro guardarRegistro(@RequestBody Registro registro){
        return registrorepository.save(registro);
    }



    // este metodo sirve para buscar un registro por id
    @GetMapping("/altas-bajas/{id}")
    public  ResponseEntity<Registro> obtenerRegistroPorId(@PathVariable Long id){
        Registro registro= registrorepository.findById(id)
                            .orElseThrow(()-> new ResourceNotFoundException("No existe el registro con el ID :"+ id));
        return ResponseEntity.ok(registro);
    
    }


    @PutMapping("/altas-bajas/{id}")
    public  ResponseEntity<Registro>actualizarRegistroPorId(@PathVariable Long id, @RequestBody Registro detallesRegistro){
        Registro registro= registrorepository.findById(id)
                            .orElseThrow(()-> new ResourceNotFoundException("No existe el registro con el ID :"+ id));
                     
        
       registro.setNombre(detallesRegistro.getNombre());     
       registro.setApellido(detallesRegistro.getApellido());
       registro.setArea(detallesRegistro.getArea());
       registro.setNombreHerramienta(detallesRegistro.getNombreHerramienta());
       registro.setTipo(detallesRegistro.getTipo());
       registro.setCantidad(detallesRegistro.getCantidad());
       registro.setFechaSalida(detallesRegistro.getFechaSalida());
     
       
    Registro registroActualizado = registrorepository.save(registro);
        return ResponseEntity.ok(registroActualizado);
    
}
    @DeleteMapping("/altas-bajas/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarregistro(@PathVariable Long id){
    Registro registro = registrorepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("No existe el registro con el ID : " + id));
    
    registrorepository.delete(registro);
    Map<String, Boolean> respuesta = new HashMap<>();
    respuesta.put("eliminar",Boolean.TRUE);
    return ResponseEntity.ok(respuesta);
}



}
