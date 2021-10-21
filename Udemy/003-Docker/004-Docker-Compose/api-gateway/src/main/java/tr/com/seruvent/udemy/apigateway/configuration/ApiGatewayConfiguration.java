package tr.com.seruvent.udemy.apigateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator ApiGatewayRoutingConfiguration(RouteLocatorBuilder routeLocatorBuilder){

        return routeLocatorBuilder
                .routes()
                    .route(predicateSpec -> predicateSpec.path("/currency-exchange/**").uri("lb://currency-exchange-service"))
                    .route(predicateSpec -> predicateSpec.path("/currency-conversion/**").uri("lb://currency-conversion-service"))
                .build();
    }
}
