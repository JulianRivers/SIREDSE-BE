package BackendSiadseUfps.siadse.service.interfaces;

import BackendSiadseUfps.siadse.dto.ComentarioDTO;

public interface ComentarioServiceInterface {
    ComentarioDTO createComment(ComentarioDTO comentarioDTO, Integer mediaId);
    ComentarioDTO updateComment(ComentarioDTO comentarioDTO);
    void deleteComment(Integer comentarioId);
}
