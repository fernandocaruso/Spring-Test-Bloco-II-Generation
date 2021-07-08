package br.org.generation.blogpessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import br.org.generation.blogpessoal.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @BeforeAll
    void start() throws ParseException {

       
        Usuario usuario = new Usuario(0L, "Fernando Caruso", "caruso@email.com.br", "13465278");
        
        if(usuarioRepository.findByLogin(usuario.getLogin()) != null)
			usuarioRepository.save(usuario);
        
        usuario = new Usuario(0, "Madalena Caruso", "madah@email.com.br", "13465278");

        if(usuarioRepository.findByLogin(usuario.getLogin()) != null)
            usuarioRepository.save(usuario);

        usuario = new Usuario(0, "Polianna Caruso", "polianna@email.com.br", "13465278");

        if(usuarioRepository.findByLogin(usuario.getLogin()) != null)
            usuarioRepository.save(usuario);

       	usuario = new Usuario(0, "Bruce Wayne", "batman@email.com.br", "13465278");

        if(usuarioRepository.findByLogin(usuario.getLogin()) != null)
            usuarioRepository.save(usuario);
  }

    @Test
    @DisplayName("💾 Retorna o nome")
    public void findFirstByNomeRetornaNome() throws Exception {
        Usuario usuario = usuarioRepository.findByNome("Fernando Caruso");
        assertTrue(usuario.getNome().equals("Fernando Caruso"));
  }

    @Test
    @DisplayName("💾 Retorna 3 usuarios")
    public void findAllByNomeContainingIgnoreCaseRetornaTresUsuarios() {
        List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Caruso");
        assertEquals(3, listaDeUsuarios.size());
  }

    @AfterAll
    public void end() {
        usuarioRepository.deleteAll();
    }
}