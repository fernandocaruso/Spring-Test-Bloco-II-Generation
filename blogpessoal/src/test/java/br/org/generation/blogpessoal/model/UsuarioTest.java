package br.org.generation.blogpessoal.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UsuarioTest {

    public Usuario usuario, usuario2, usuario3;
    public Usuario usuarioErro = new Usuario();

    @Autowired
    private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    Validator validator = factory.getValidator();

    @BeforeEach
    public void start() throws ParseException {
       
        usuario = new Usuario();
        
        usuario.setId(0L);
        usuario.setNome("Fernando Caruso");
        usuario.setLogin("caruso@gmail.com.br");
        usuario.setSenha("12345678");
        
        usuario2 = new Usuario(1L, "Madalena Caruso", "madahqueen@gmail.com", "amoopapai");
        usuario3 = new Usuario(2L, "Polianna", "polly@email.com.br", "amoamamae");
        
        
       
    		}

    @Test
    @DisplayName("✔ Valida Atributos Não Nulos")
    void testValidaAtributos() {

        Set<ConstraintViolation<Usuario>> violacao = validator.validate(usuario);
        System.out.println(violacao.toString());
        assertTrue(violacao.isEmpty());

    }

    @Test
    @DisplayName("❌ Valida Atributos Nulos")
    void testValidaAtributosNulos() {
        
        usuarioErro.setLogin("paulo@email.com.br");
        Set<ConstraintViolation<Usuario>> violacao = validator.validate(usuarioErro);
        System.out.println(violacao.toString());
        assertFalse(violacao.isEmpty());
   
    }

}