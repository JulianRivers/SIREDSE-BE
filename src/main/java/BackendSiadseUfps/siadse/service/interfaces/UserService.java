package BackendSiadseUfps.siadse.service.interfaces;

import BackendSiadseUfps.siadse.dto.UserDTO;
import BackendSiadseUfps.siadse.entity.User;

public interface UserService {

    User registerUser(UserDTO userDTO);
    
    boolean loginUser(String email, String password);
    void logoutUser(String token);

}
