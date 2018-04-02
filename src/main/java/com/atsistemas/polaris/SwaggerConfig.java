package com.atsistemas.polaris;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.Api;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
class SwaggerConfig {

	/**
	 * Create Swagger Api configuration
	 *
	 * @return Swagger Docket
	 */
	@Bean
	public Docket denebApi() {

		return new Docket(DocumentationType.SWAGGER_2).select()

//				.apis(RequestHandlerSelectors.basePackage("com.atsistemas.polaris.controller")).build()
				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class)).build()
				.apiInfo(apiInfo());
	}

    /**
     * Generate Api Info
     *
     * @return Swagger API Info
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Apidemo")
                .description("Demo API")
                .version("0.1-SNAPSHOT")
                .termsOfServiceUrl("https://es.wikipedia.org/wiki/Polaris_(estrella)")
                .license("Open source licensing")
                .licenseUrl("https://help.github.com/articles/open-source-licensing/")
                .build();
    }
}
