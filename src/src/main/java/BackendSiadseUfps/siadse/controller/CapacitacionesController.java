package BackendSiadseUfps.siadse.controller;

import BackendSiadseUfps.siadse.dto.CapacitacionesDTO;
import BackendSiadseUfps.siadse.service.interfaces.CapacitacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/capacitaciones")
public class CapacitacionesController {

    @Autowired
    private CapacitacionesService capacitacionesService;

    @PostMapping
    public ResponseEntity<CapacitacionesDTO> crearCapacitaciones(@RequestBody CapacitacionesDTO capacitacionesDTO) {
        CapacitacionesDTO capacitacionesCreado = capacitacionesService.crearCapacitaciones(capacitacionesDTO);
        return new ResponseEntity<>(capacitacionesCreado, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CapacitacionesDTO> buscarCapacitacionesPorId(@PathVariable Integer id) {
        CapacitacionesDTO capacitaciones = capacitacionesService.buscarCapacitacionesPorId(id);
        return new ResponseEntity<>(capacitaciones, HttpStatus.OK);
    }

    
}
