package BackendSiadseUfps.siadse.service.implementations;

import BackendSiadseUfps.siadse.dto.ComentarioDTO;
import BackendSiadseUfps.siadse.entity.Comentario;
import BackendSiadseUfps.siadse.entity.ContenidoMultimedia;
import BackendSiadseUfps.siadse.entity.OurUsers;
import BackendSiadseUfps.siadse.repository.ComentarioRepository;
import BackendSiadseUfps.siadse.repository.ContenidoMultimediaRepository;
import BackendSiadseUfps.siadse.repository.OurUserRepo;
import BackendSiadseUfps.siadse.service.interfaces.ComentarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComentarioServiceImpl implements ComentarioService {

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
        responseDTO.setContenidoMultimediaId(savedComentario.getContenidoMultimedia().getId());
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
        responseDTO.setContenidoMultimediaId(updatedComentario.getContenidoMultimedia().getId());
        BeanUtils.copyProperties(updatedComentario, responseDTO);

        return responseDTO;
    }

    @Override
    public void deleteComment(Integer comentarioId) {
        Comentario comentario = comentarioRepository.findById(comentarioId)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró el comentario con el ID especificado"));

        comentarioRepository.delete(comentario);
    }


    @Override
    public List<ComentarioDTO> getAllComments() {
        List<Comentario> comentarios = comentarioRepository.findAll();
        return comentarios.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ComentarioDTO> getCommentsByMedia(Integer mediaId) {
        ContenidoMultimedia media = contenidoMultimediaRepository.findById(mediaId)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró el archivo multimedia con el ID especificado"));
        List<Comentario> comentarios = comentarioRepository.findByContenidoMultimedia(media);
        return comentarios.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ComentarioDTO> getCommentsByUser(Integer userId) {
        OurUsers user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró el usuario con el ID especificado"));
        List<Comentario> comentarios = comentarioRepository.findByUser(user);
        return comentarios.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private ComentarioDTO convertToDTO(Comentario comentario) {
        ComentarioDTO comentarioDTO = new ComentarioDTO();
        comentarioDTO.setContenidoMultimediaId(comentario.getContenidoMultimedia().getId());
        comentarioDTO.setUserId(comentario.getUser().getId());
        BeanUtils.copyProperties(comentario, comentarioDTO);
        return comentarioDTO;
    }
}