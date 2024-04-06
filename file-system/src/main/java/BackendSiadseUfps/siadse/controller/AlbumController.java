package BackendSiadseUfps.siadse.controller;

import BackendSiadseUfps.siadse.dto.AlbumDTO;
import BackendSiadseUfps.siadse.service.interfaces.AlbumServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/album")
public class AlbumController {

    @Autowired
    private AlbumServiceInterface albumService;

    @PostMapping
    public ResponseEntity<AlbumDTO> createAlbum(@RequestBody AlbumDTO albumDTO) {
        AlbumDTO createdAlbum = albumService.createAlbum(albumDTO);
        return new ResponseEntity<>(createdAlbum, HttpStatus.CREATED);
    }
}
