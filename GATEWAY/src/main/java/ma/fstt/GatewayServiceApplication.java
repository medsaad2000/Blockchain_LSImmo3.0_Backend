package ma.fstt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.loadbalancer.core.DiscoveryClientServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }
//    @Bean
//    RouteLocator staticRoutes(RouteLocatorBuilder builder){
//        return builder.routes()
//                .route(r->r.path("/annonces/**").uri("http://localhost:8081").id("r1"))
//                .route(r->r.path("/users/**").uri("http://localhost:8081").id("r1"))
//                .build();
//    }
@Bean
DiscoveryClientRouteDefinitionLocator dynamicRoutes (ReactiveDiscoveryClient rdc , DiscoveryLocatorProperties dlp){
        return new DiscoveryClientRouteDefinitionLocator(rdc,dlp);
}
}
