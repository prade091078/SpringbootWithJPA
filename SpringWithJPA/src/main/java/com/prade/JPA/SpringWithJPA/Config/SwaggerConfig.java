package com.prade.JPA.SpringWithJPA.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
     
    @Bean
    public Docket api() {
    	return new Docket(DocumentationType.SWAGGER_2)
    			.apiInfo(buildApiInfo())
    			.select()
				.paths(postPaths()).build();
    }
	
    private Predicate<String> postPaths() {
		return or(regex("/api/posts.*"), regex("/v1/.*"));
	}
    
    private ApiInfo buildApiInfo() {
        Contact contact = new Contact("J4U", "https://J4USolutions.com", "prade.explore@j4u.com");
        return new ApiInfoBuilder()
                .title("MyLearningwithSPRINGJPA")
                .description("JPA API reference for Internal use of J4U customers")
                .license(" J4U license")
                .version("1.0")
                .contact(contact)
                .licenseUrl("licenseURl")
                .build();
    }

	
}
