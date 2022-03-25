//http://localhost:8080/swagger-ui.html#
package tr.edu.medipol.ilerijavauyg.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("tr.edu.medipol.ilerijavauyg"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }


    private ApiInfo apiInfo() {
        return new ApiInfo("Medipol Ileri Java", "API test", null, null, null, null, null);
    }



}
