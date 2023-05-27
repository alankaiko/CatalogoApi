package br.com.catalogo;

import br.com.catalogo.config.property.CatalogoApiProp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(CatalogoApiProp.class)
public class CatalogoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogoApiApplication.class, args);
		System.out.println("APLICAÇÃO FUNCIONANDO...");
	}

}
