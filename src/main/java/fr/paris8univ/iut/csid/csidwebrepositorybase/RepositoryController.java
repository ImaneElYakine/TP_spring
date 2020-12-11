package fr.paris8univ.iut.csid.csidwebrepositorybase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/repositories")
public class RepositoryController {
    private final List<Repository> repositories;
    private final RepositoryService repositoryService;
    private Repository rep = new Repository("imane", "ely", 2, 2);

    // Constructeur
    @Autowired
    public RepositoryController(RepositoryService repositoryService){
        repositories = new ArrayList<>();
        repositories.add(rep);
        this.repositoryService = repositoryService;
    }

    // Renvoi une liste de repositories
    @GetMapping
    public List<Repository> getRepositories() {
        //return this.repositories;
        return this.repositoryService.getRepositories();
    }

    // Renvoi un répository
    @GetMapping("/{name}")
    public ResponseEntity<Repository> findOneRepository(@PathVariable String name){
        return this.repositoryService.findOneRepository(name)
                .map(x->ResponseEntity.ok(x))
                .orElse(ResponseEntity.notFound().build());
    }

    // Créer un repository
    @PostMapping
    public ResponseEntity<Repository> createRepository(@RequestBody Repository repository) throws URISyntaxException {
        repositoryService.createRepository(repository);
        return ResponseEntity.created(new URI("repositories/created"+repository.getName())).build();
    }

    // Supprime un repository
    @DeleteMapping("/name")
    public ResponseEntity deleteRepository(@PathVariable String name){
        repositoryService.deleteRepository(name);
        return ResponseEntity.noContent().build();
    }

}
