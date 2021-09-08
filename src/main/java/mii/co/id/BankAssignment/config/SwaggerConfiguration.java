/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.BankAssignment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author user
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfo(
                "Bank Assignment- Siti Mahfuzdoh",
                "Documentation of Data Nasabah CRUD Assignemnt Bank API Documentation. We're defining how to communicate with our API using our request and response via endpoint or url. Please read the documentation to know how to approach it.",
                "1.0",
                "Terms of Service",
                "Assigment BANK-UDOH created by : Siti Mahfuzdoh",
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0"
                );
    }
}
