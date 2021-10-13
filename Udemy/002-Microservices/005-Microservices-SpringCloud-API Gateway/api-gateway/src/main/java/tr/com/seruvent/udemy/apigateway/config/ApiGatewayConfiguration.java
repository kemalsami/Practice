package tr.com.seruvent.udemy.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApiGatewayConfiguration {


    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder routeLocatorBuilder){

        /**
         * API-GATEWAY üzerindeki servisler aşağıdaki gibi yönlendirilmektedir
         *      /get üzerinden gelen servisler http://httpbin.org:80/get adresine yönlendirilir
         *      /currency-exchange/** üzerinden gelen istekler http://localhost:8101/currency-exchange/** adresine yönlendirilir
         */

        return routeLocatorBuilder.routes()
                .route(p -> p.path("/get").uri("http://httpbin.org:80"))
                //.route(p -> p.path("/currency-exchange/**").uri("http://localhost:8101/"))
                .route(p -> p.path("/currency-exchange/**").uri("lb://currency-exchange-service"))
                .route(p -> p.path("/currency-conversion/**").uri("lb://currency-conversion-service"))
                .build();
    }

}
