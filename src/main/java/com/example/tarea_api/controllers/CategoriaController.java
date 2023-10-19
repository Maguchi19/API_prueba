package com.example.tarea_api.controllers;


import com.example.tarea_api.entitys.Categoria;
import com.example.tarea_api.interfaces.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@RequestMapping("/api")
public class CategoriaController {
    @Autowired
    private ICategoriaService lognegocioCatego;

    @GetMapping("/categorias")
    public List<Categoria> muestratodasCategorias(){
        return lognegocioCatego.consultarTodasCategorias();
    }

    @GetMapping("/categorias/nivel/{n}")
    public List<Categoria> muestraporNivel(@PathVariable("n") int n){
        return lognegocioCatego.consultarPorNivel(n);
    }

    @GetMapping("/categorias/nom/{nombre}")
    public ResponseEntity<?> muestraporNombre(@PathVariable("nombre") String nom){
        return lognegocioCatego.consultarbyNombre(nom);
    }

    @GetMapping("/categorias/{id}")
    public ResponseEntity<Categoria> localizar(@PathVariable("id") int idCat){
        return lognegocioCatego.consultarUno(idCat);
    }

    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<?> eliminar(@PathVariable("id") int idCat){
        return lognegocioCatego.eliminarCategoria(idCat);

    }

    @PostMapping("/categorias")
    public String insertar(@RequestBody Categoria objcat){
        lognegocioCatego.insertarCategoria(objcat);
        return "La categoria fue registrada correctamente";
    }

    @PutMapping("/categorias/{id}")
    public String actualizar(@RequestBody Categoria obj, @PathVariable("id") int idCat){
        lognegocioCatego.actualizarCategoria(obj, idCat);
        return "Los datos de la categoria fue actualizado correctamente";
    }


}
