package hr.tvz.wauj.vjezbe.app.web;

import hr.tvz.wauj.vjezbe.app.security.SecurityUtils;
import hr.tvz.wauj.vjezbe.app.user.UserDTO;
import hr.tvz.wauj.vjezbe.app.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/current-user")
    public ResponseEntity<UserDTO> getCurrentUser() {
        return SecurityUtils.getCurrentUserUsername()
                .map(
                        username -> userService.findByUsername(username)
                                .map(ResponseEntity::ok)
                                .orElseGet(
                                        () -> ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build()
                                )
                )
                .orElseGet(
                        () -> ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build()
                );
    }

}
