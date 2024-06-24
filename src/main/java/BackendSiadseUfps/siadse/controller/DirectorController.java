package BackendSiadseUfps.siadse.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import BackendSiadseUfps.siadse.service.interfaces.DirectorService;

@RestController
@RequestMapping("/director")
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    @GetMapping("/content")
    public ResponseEntity<String> manageContent() {
        // Lógica para manejar el contenido
        return ResponseEntity.ok("Content managed");
    }
}
