package BackendSiadseUfps.siadse.service.implementations;

import BackendSiadseUfps.siadse.dto.ComentarioDTO;
import BackendSiadseUfps.siadse.entity.Comentario;
import BackendSiadseUfps.siadse.entity.ContenidoMultimedia;
import BackendSiadseUfps.siadse.entity.OurUsers;
import BackendSiadseUfps.siadse.repository.ComentarioRepository;
import BackendSiadseUfps.siadse.repository.ContenidoMultimediaRepository;
import BackendSiadseUfps.siadse.repository.OurUserRepo;
import BackendSiadseUfps.siadse.service.interfaces.ComentarioServiceInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ComentarioService implements ComentarioServiceInterface {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private ContenidoMultimediaRepository contenidoMultimediaRepository;

    @Autowired
    private OurUserRepo userRepository;

    @Override
    public ComentarioDTO createComment(ComentarioDTO comentarioDTO, Integer mediaId) {
        ContenidoMultimedia media = contenidoMultimediaRepository.findById(mediaId)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró el archivo multimedia con el ID especificado"));

        OurUsers user = userRepository.findById(comentarioDTO.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("No se encontró el usuario con el ID especificado"));

        Comentario comentario = new Comentario();
        comentario.setFechaCreacion(new Date());
        comentario.setComentario(comentarioDTO.getComentario());
        comentario.setContenidoMultimedia(media);
        comentario.setUser(user);

        Comentario savedComentario = comentarioRepository.save(comentario);

        ComentarioDTO responseDTO = new ComentarioDTO();
        responseDTO.setUserId(savedComentario.getUser().getId());
        BeanUtils.copyProperties(savedComentario, responseDTO);

        return responseDTO;
    }

    @Override
    public ComentarioDTO updateComment(ComentarioDTO comentarioDTO) {
        Comentario existingComentario = comentarioRepository.findById(comentarioDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("No se encontró el comentario con el ID especificado"));

        existingComentario.setComentario(comentarioDTO.getComentario());
        existingComentario.setFechaCreacion(new Date());
        Comentario updatedComentario = comentarioRepository.save(existingComentario);

        ComentarioDTO responseDTO = new ComentarioDTO();
        BeanUtils.copyProperties(updatedComentario, responseDTO);

        return responseDTO;
    }

    @Override
    public void deleteComment(Integer comentarioId) {
        Comentario comentario = comentarioRepository.findById(comentarioId)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró el comentario con el ID especificado"));

        comentarioRepository.delete(comentario);
    }
}