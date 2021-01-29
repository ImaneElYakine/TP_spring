package fr.paris8univ.iut.csid.csidwebrepositorybase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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

    // Retourne le contenu d'un repository en JSON via l'API GitHub
    public GithubRepositoryDTO getJSON(String name,String owner) throws URISyntaxException {
        GithubRepositoryDTO json = restTemplate.getForEntity(
                new URI("https://api.github.com/repos/"+owner+"/"+name), GithubRepositoryDTO.class).getBody();
        return json;
    }

    // Créer une issue et le post sur GitHub via l'API
    public void postIssue(String title, String body) {
        Issue issue = new Issue(title, body);
        String repoURL = "https://api.github.com/repos/ImaneElYakine/testIssue";
        String token = "7abf67037e304aca95bbc9f9286833cd6760dca9";
        HttpHeaders requete = new HttpHeaders();
        requete.add("Authorization", "Bearer " + token);
        HttpEntity<Issue> reponse = restTemplate.exchange(
                repoURL,
                HttpMethod.POST,
                new HttpEntity<>(issue, requete),
                Issue.class);
    }

}
