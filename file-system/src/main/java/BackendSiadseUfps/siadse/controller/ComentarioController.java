package BackendSiadseUfps.siadse.controller;

import BackendSiadseUfps.siadse.dto.ComentarioDTO;
import BackendSiadseUfps.siadse.service.interfaces.ComentarioServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public/comment")
public class ComentarioController {

    @Autowired
    private ComentarioServiceInterface comentarioService;

    @PostMapping("/create")
    public ResponseEntity<ComentarioDTO> createComment(@RequestBody ComentarioDTO comentarioDTO,
                                                       @RequestParam("mediaId") Integer mediaId) {
        ComentarioDTO createdComment = comentarioService.createComment(comentarioDTO, mediaId);
        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ComentarioDTO> updateComment(@RequestParam("id") Integer comentarioId,
                                                       @RequestBody ComentarioDTO comentarioDTO) {
        comentarioDTO.setId(comentarioId);
        ComentarioDTO updatedComment = comentarioService.updateComment(comentarioDTO);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteComment(@RequestParam("id") Integer comentarioId) {
        comentarioService.deleteComment(comentarioId);
        return new ResponseEntity<>("Comentario borrado exitosamente", HttpStatus.OK);
    }
}
