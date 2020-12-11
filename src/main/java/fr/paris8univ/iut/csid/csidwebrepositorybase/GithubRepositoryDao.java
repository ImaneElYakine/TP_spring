package fr.paris8univ.iut.csid.csidwebrepositorybase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GithubRepositoryDao {

    private final RestTemplate restTemplate;

    @Autowired
    public GithubRepositoryDao(RestTemplateBuilder restBuilder){
        this.restTemplate = restBuilder.build();
    }
}
