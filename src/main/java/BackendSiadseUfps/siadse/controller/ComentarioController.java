package BackendSiadseUfps.siadse.controller;

import BackendSiadseUfps.siadse.dto.ComentarioDTO;
import BackendSiadseUfps.siadse.service.interfaces.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/comment")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @PostMapping
    public ResponseEntity<ComentarioDTO> createComment(@RequestBody ComentarioDTO comentarioDTO,
                                                       @RequestParam("mediaId") Integer mediaId) {
        ComentarioDTO createdComment = comentarioService.createComment(comentarioDTO, mediaId);
        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ComentarioDTO> updateComment(@RequestParam("id") Integer comentarioId,
                                                       @RequestBody ComentarioDTO comentarioDTO) {
        comentarioDTO.setId(comentarioId);
        ComentarioDTO updatedComment = comentarioService.updateComment(comentarioDTO);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteComment(@RequestParam("id") Integer comentarioId) {
        comentarioService.deleteComment(comentarioId);
        return new ResponseEntity<>("Comentario borrado exitosamente", HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ComentarioDTO>> getAllComments() {
        List<ComentarioDTO> comentarios = comentarioService.getAllComments();
        return new ResponseEntity<>(comentarios, HttpStatus.OK);
    }

    @GetMapping("/media")
    public ResponseEntity<List<ComentarioDTO>> getCommentsByMedia(@RequestParam("mediaId") Integer mediaId) {
        List<ComentarioDTO> comentarios = comentarioService.getCommentsByMedia(mediaId);
        return new ResponseEntity<>(comentarios, HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<List<ComentarioDTO>> getCommentsByUser(@RequestParam("userId") Integer userId) {
        List<ComentarioDTO> comentarios = comentarioService.getCommentsByUser(userId);
        return new ResponseEntity<>(comentarios, HttpStatus.OK);
    }
}
