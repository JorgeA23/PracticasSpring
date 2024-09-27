package com.microservices.mifirstmicroservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class controller {

	private List<String> paises = new ArrayList<String>();

	public controller() {
		paises.add("Colombia");
		paises.add("Argentina");
		paises.add("Perú");
		paises.add("Chile");
		paises.add("Venezuela");
		paises.add("Ecuador");
		paises.add("Brasil");
		paises.add("Uruguai");
		paises.add("Paraguai");
		paises.add("Bolivia");
	}

	// Con este metodo podemos ver toda la lista
	@GetMapping("/paises")
	public List<String> mostrarTodo() {
		return paises;
	}

	// Con este metodo Post podemos agregar un nuevo elemento a la lista
	
	@GetMapping("/addPais/{index}")
	public String agregar(@PathVariable String index) {
		paises.add(index);
		return "Pais agregado exitosamente!!";
	}

	//Con este metodo podemos buscar un elemento(Pais) en especifico por su posicion
	@GetMapping("/pais/{pais}")
	public String mostrarUnPais(@PathVariable int pais) {
		if (pais < paises.size()) {
			return paises.get(pais);
		} else {
			return "La lista no contiene el objeto seleccionado";
		}
	}

	//Con este metodo actualizamos el pais mediante su posicion dentro de la lista
	@PutMapping("/{index}")
	public String actualizaPais(@PathVariable int index, @RequestBody String newItem) {
		if (index >= 0 && index < paises.size()) {
			paises.set(index, newItem);
			return "Pais actualizado";
		} else {
			return "El pais no existe en la lista";
		}
	}

	//Este metodo nos sirve para eliminar un pais usando su posicion dentro de la lista
	@DeleteMapping("/{index}")
	public String eliminaPais(@PathVariable int index) {
		if (index >= 0 && index < paises.size()) {
			paises.remove(index);
			return "Pais eliminado";
		} else {
			return "no se ha encontrado el pais indicado!";
		}
	}

}
