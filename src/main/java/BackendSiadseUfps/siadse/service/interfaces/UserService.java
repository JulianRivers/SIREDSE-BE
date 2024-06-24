package BackendSiadseUfps.siadse.service.interfaces;

import BackendSiadseUfps.siadse.dto.UserDTO;
import BackendSiadseUfps.siadse.entity.User;

public interface UserService {

    User registerUser(UserDTO userDTO);
    User createDirector(UserDTO userDTO);
    
    boolean loginUser(User user);
    void logoutUser(String token);

}
