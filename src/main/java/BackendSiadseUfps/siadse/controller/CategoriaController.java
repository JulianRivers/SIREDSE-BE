package BackendSiadseUfps.siadse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import BackendSiadseUfps.siadse.entity.Categoria;
import BackendSiadseUfps.siadse.repository.CategoriasRepository;

@RestController
@RequestMapping("/api/category")
public class CategoriaController {
	
	@Autowired
	private CategoriasRepository categoriaRepo;
	
	
	  @PostMapping 
	  public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria categoria) {
	  Categoria createdCategoria = categoriaRepo.save(categoria);
	  return new ResponseEntity<>(createdCategoria, HttpStatus.CREATED);
	 }

}
