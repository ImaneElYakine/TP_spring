package fr.paris8univ.iut.csid.csidwebrepositorybase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Component
public class GithubRepositoryDao {

    private final RestTemplate restTemplate;

    @Autowired
    public GithubRepositoryDao(RestTemplateBuilder restBuilder){
        this.restTemplate = restBuilder.build();
    }

    //
    public GithubRepositoryDTO getJSON(String name,String owner) throws URISyntaxException {
        GithubRepositoryDTO json = restTemplate.getForEntity(
                new URI("https://api.github.com/repos/"+owner+"/"+name), GithubRepositoryDTO.class).getBody();
        return json;
    }
}
