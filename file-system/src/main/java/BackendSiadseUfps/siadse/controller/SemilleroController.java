package BackendSiadseUfps.siadse.controller;

import BackendSiadseUfps.siadse.dto.AlbumDTO;
import BackendSiadseUfps.siadse.dto.ReqRes;
import BackendSiadseUfps.siadse.dto.SemilleroDTO;
import BackendSiadseUfps.siadse.service.interfaces.NormatividadService;
import BackendSiadseUfps.siadse.service.interfaces.SemilleroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/public/seedbed")
public class SemilleroController {

    @Autowired
    private SemilleroService semilleroService;

    @PostMapping
    public ResponseEntity<SemilleroDTO> createSeedbed(@RequestBody SemilleroDTO semilleroDTO) {
        SemilleroDTO semillero =semilleroService.crearSemillero(semilleroDTO);
        return new ResponseEntity<>(semillero, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SemilleroDTO>> listSeedbed() {
        throw new UnsupportedOperationException("La funcionalidad aún no está implementada");
    }

    @GetMapping("/{id}")
    public ResponseEntity<SemilleroDTO> getSeedbeb(@PathVariable Integer id) {
        throw new UnsupportedOperationException("La funcionalidad aún no está implementada");
    }

    @PutMapping
    public ResponseEntity<List<SemilleroDTO>> updateSeedbed() {
        throw new UnsupportedOperationException("La funcionalidad aún no está implementada");
    }

    @DeleteMapping
    public ResponseEntity<List<SemilleroDTO>> deleteSeedbed() {
        throw new UnsupportedOperationException("La funcionalidad aún no está implementada");
    }
}
