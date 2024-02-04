package naranco.dam.proyectoalojamientos.controller;

import naranco.dam.proyectoalojamientos.model.Usuarios;
import naranco.dam.proyectoalojamientos.services.UsuariosService;
import naranco.dam.proyectoalojamientos.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuariosController {

        @Autowired
        private UsuariosService usuarioService;

        @Autowired
        private JWTUtil jwtUtil;

        @PostMapping("/usuario/login")
        public ResponseEntity<String> login(@RequestBody Usuarios usuarioRequest){
            Usuarios usuario=usuarioService.findByNombreAndPassword(usuarioRequest.getNombre(),usuarioRequest.getPassword());
            if(usuario!=null){
                String token=jwtUtil.create(String.valueOf(usuario.getId()),usuario.getNombre());
                return ResponseEntity.ok(token);
            }
            return ResponseEntity.notFound().build();
        }
}
