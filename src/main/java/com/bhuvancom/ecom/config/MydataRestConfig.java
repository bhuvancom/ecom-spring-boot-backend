package com.bhuvancom.ecom.config;

import com.bhuvancom.ecom.entity.Product;
import com.bhuvancom.ecom.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MydataRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] theUnSupportedMethod = {HttpMethod.DELETE, HttpMethod.POST, HttpMethod.PUT};

        //for product
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((metaData, httpMethod) -> httpMethod.disable(theUnSupportedMethod))
                .withCollectionExposure((metaData, httpMethod) -> httpMethod.disable(theUnSupportedMethod));
        System.out.println("Inside disable");
        //for product category
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metaData, httpMethod) -> httpMethod.disable(theUnSupportedMethod))
                .withCollectionExposure((metaData, httpMethod) -> httpMethod.disable(theUnSupportedMethod));

    }
}
