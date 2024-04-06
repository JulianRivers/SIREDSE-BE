package BackendSiadseUfps.siadse.controller;

import java.io.IOException;

import BackendSiadseUfps.siadse.dto.ContenidoMutimediaDTO;
import BackendSiadseUfps.siadse.service.interfaces.ContenidoMultimediaServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@RestController
@RequestMapping("/public/media")
public class ContenidoMultimediaController {

    @Autowired
    private ContenidoMultimediaServiceInterface contenidoMultimediaService;

    @PostMapping("/upload")
    public ResponseEntity<ContenidoMutimediaDTO> createMediaContent(@RequestParam Integer albumId, @RequestParam String titulo,
                                                                          @RequestParam("file") MultipartFile file) {
        try {
            ContenidoMutimediaDTO createdContenido = contenidoMultimediaService.createMediaContent(albumId,titulo, file);
            return new ResponseEntity<>(createdContenido, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
