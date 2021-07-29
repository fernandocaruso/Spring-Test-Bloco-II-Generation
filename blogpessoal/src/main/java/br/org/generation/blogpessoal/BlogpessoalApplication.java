package br.org.generation.blogpessoal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class BlogpessoalApplication {

	@GetMapping
	public ModelAndView swaggerUi() {
		
		return new ModelAndView("redirect:/swagger-ui/");
		//swagger página home do projeto
		//n esquecer de usar as duas barras p abrir o swagger: -> /swagger-ui/ <- !!!!!!!!! IMPORTANTÍSSIMO!
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BlogpessoalApplication.class, args);
	}

}