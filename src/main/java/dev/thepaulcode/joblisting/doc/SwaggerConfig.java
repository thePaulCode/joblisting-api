package dev.thepaulcode.joblisting.doc;

import dev.thepaulcode.joblisting.JoblistingApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
@EnableSwagger2
public class SwaggerConfig {
    // Esta classe configura o Swagger para gerar documentação da API.

//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2).select()
//                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).paths(PathSelectors.any())
//                .build().apiInfo(apiInfo()).useDefaultResponseMessages(false);
//    }

    @Bean
    public Docket detalheApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket
                .select()
                .apis(RequestHandlerSelectors.basePackage("dev.thepaulcode.joblisting.controller"))
                // Define o pacote base que o Swagger irá escanear para encontrar controladores.
                .paths(PathSelectors.any())
                // Define que todas as rotas da API devem ser documentadas.
                .build()
                .apiInfo(this.informacoesApi().build())
                // Define informações gerais da API usando o método 'informacoesApi'
                .consumes(new HashSet<String>(Arrays.asList("application/json")))
                .produces(new HashSet<String>(Arrays.asList("application/json")));
                // Define os tipos de mídia que a API consome e produz.

        return docket;
        // Retorna a configuração do Swagger para a documentação da API.
    }

    @Bean
    public ApiInfo apiInfo() {
        // Configura as informações gerais da API que serão exibidas na documentação do Swagger.

        final ApiInfoBuilder builder = new ApiInfoBuilder();
        return builder.build();
    }

    private Contact contato() {
        // Cria um objeto Contact com informações de contato.

        return new Contact(
                "Paulo Santos",
                "https://github.com/thePaulCode",
                "");
    }

    @Bean
    protected ApiInfoBuilder informacoesApi() {
        // Configura as informações gerais da API, como título, descrição, versão, termos de serviço e informações de contato.


        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("JobListing - Rest API");
        apiInfoBuilder.description("Desenvolvimento de um sistema de listagem de vagas de emprego, " +
                "que permite aos usuários visualizar, pesquisar e adicionar novas vagas. " +
                "Uso de Springboot REST API e MongoDB.");
        apiInfoBuilder.version("1.0");
        apiInfoBuilder.termsOfServiceUrl("Termo de uso: Open Source");
        //apiInfoBuilder.license("Licença - Sua Empresa");
        //apiInfoBuilder.licenseUrl("http://www.seusite.com.br");
        apiInfoBuilder.contact(this.contato());

        return apiInfoBuilder;
        // Retorna as informações gerais da API configuradas.

    }

    public static void main(String[] args) {
        SpringApplication.run(JoblistingApplication.class, args);
        // Inicia a aplicação Spring Boot.
    }


}
