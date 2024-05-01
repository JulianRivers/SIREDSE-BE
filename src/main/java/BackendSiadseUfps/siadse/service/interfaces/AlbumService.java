package BackendSiadseUfps.siadse.service.interfaces;

import BackendSiadseUfps.siadse.dto.AlbumDTO;

public interface AlbumService {

    public AlbumDTO createAlbum (AlbumDTO albumDTO);
    void deleteAlbum(Integer albumId);
}
