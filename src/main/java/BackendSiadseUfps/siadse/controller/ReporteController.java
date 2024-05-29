package BackendSiadseUfps.siadse.controller;

import BackendSiadseUfps.siadse.dto.PostDTO;
import BackendSiadseUfps.siadse.entity.Post;
import BackendSiadseUfps.siadse.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import BackendSiadseUfps.siadse.dto.RoleDTO;
import BackendSiadseUfps.siadse.dto.UserDTO;
import BackendSiadseUfps.siadse.entity.User;
import BackendSiadseUfps.siadse.repository.UserRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<UserDTO> getUserInfo(@RequestParam String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        UserDTO userDTO = convertToUserDTO(user);
        return ResponseEntity.ok(userDTO);
    }

   /* @GetMapping("/enrolled-students")
    public ResponseEntity<List<UserDTO>> getEnrolledStudents() {
        List<UserDTO> studentDTOs = new ArrayList<>();
        studentDTOs.add(new UserDTO("username1", "name1", "email1@example.com", "password1", "codigo1", 1, 20, "direccion1", "123456789", new RoleDTO(1L, "role1")));
        studentDTOs.add(new UserDTO("username2", "name2", "email2@example.com", "password2", "codigo2", 2, 21, "direccion2", "987654321", new RoleDTO(2L, "role2")));
        return ResponseEntity.ok(studentDTOs);
    }*/


    @GetMapping("/enrolled-students")
    public ResponseEntity<List<UserDTO>> getAllStudents() {
        List<User> allStudents = userRepository.findByRoleId(3L);
        List<UserDTO> studentDTOs = allStudents.stream()
                .map(this::convertToUserDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(studentDTOs);
    }




    private UserDTO convertToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPasswsirord(user.getPassword());
        userDTO.setCodigoUniversidad(user.getCodigoUniversidad());
        userDTO.setSemestreActual(user.getSemestreActual());
        userDTO.setEdad(user.getEdad());
        userDTO.setDireccionResidencia(user.getDireccionResidencia());
        userDTO.setCelular(user.getCelular());

        // Asigna el rol si está presente en el usuario
        if (user.getRole() != null) {
            userDTO.setRole(new RoleDTO(user.getRole().getId(), user.getRole().getName()));
        }
        return userDTO;
    }


    @Autowired
    private PostRepository postRepository;

    @GetMapping("/posts/{uniqueTitleId}")
    public ResponseEntity<PostDTO> getPostByUniqueTitleId(@PathVariable String uniqueTitleId) {
        Post post = postRepository.findByUniqueTitleId(uniqueTitleId);
        if (post == null) {
            return ResponseEntity.notFound().build();
        }
        PostDTO postDTO = convertToPostDTO(post);
        return ResponseEntity.ok(postDTO);
    }


    @GetMapping("/posts")
    public ResponseEntity<List<PostDTO>> getPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostDTO> postDTOs = posts.stream()
                .map(this::convertToPostDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(postDTOs);
    }


//    @GetMapping("/posts")
//    public ResponseEntity<List<PostDTO>> getPosts() {
//        List<PostDTO> posts = new ArrayList<>();
//        posts.add(new PostDTO(1L, "Título de la publicación 1", "imagen1.jpg", new Date(), "tag1", "titulo-publicacion-1"));
//        posts.add(new PostDTO(2L, "Título de la publicación 2", "imagen2.png", new Date(), "tag2", "/posts/titulo-publicacion-2"));
//        posts.add(new PostDTO(3L, "Título de la publicación 3", null, new Date(), "tag3", "/posts/titulo-publicacion-3"));
//        return ResponseEntity.ok(posts);
//    }

    private PostDTO convertToPostDTO(Post post) {
        return PostDTO.builder()
                .id(post.getId())
                .titulo(post.getTitulo())
                .imagen(post.getImagenEncabezado())
                .fechaCreacion(post.getFechaCreacion())
                .tag(post.getTag())
                .link("/posts/" + post.getUniqueTitleId())
                .build();
    }
}




