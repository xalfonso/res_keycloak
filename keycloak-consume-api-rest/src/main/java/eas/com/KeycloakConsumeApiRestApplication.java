package eas.com;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Slf4j
@SpringBootApplication
public class KeycloakConsumeApiRestApplication {

    private RestTemplate restTemplate = new RestTemplate();


    public static void main(String[] args) {
        SpringApplication.run(KeycloakConsumeApiRestApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(ListableBeanFactory ctx) {
        return args -> {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
            map.add("grant_type", "client_credentials");
            map.add("client_id", "APP-BASE");
            map.add("client_secret", "9e8dec09-df5f-4da1-9ef5-82d5fc227537");

            HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);


            ResponseEntity<KeycloakTokenVO> exchange = restTemplate
                    .exchange("http://10.200.101.223:8084/auth/realms/CFAVORITA-SSO-INTRANET/protocol/openid-connect/token",
                            HttpMethod.POST,
                            entity,
                            KeycloakTokenVO.class);

            log.info("Response of Keycloak");
            log.info(exchange.getBody().toString());
        };
    }
}
