package one.digitalinnovation.personapi.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    Parameter authHeader = new ParameterBuilder()
            .parameterType("header")
            .name("Authorization")
            .modelRef(new ModelRef("string"))
            .build();


    @Bean
    public Docket architeture() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .globalOperationParameters(Collections.singletonList(authHeader));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("PERSON-API")
                .description("API com endpoints para testes")
                .version("0.0.1")
                .build();
    }
}
