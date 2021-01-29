package fr.paris8univ.iut.csid.csidwebrepositorybase;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepositoryService {

    private final RepositoryRepository repositoryRepository;

    public RepositoryService(RepositoryRepository repositoryRepository) {
        this.repositoryRepository= repositoryRepository;
    }

    public List<Repository> getRepositories() {
        return repositoryRepository.getRepositories();
    }

    public Optional<Repository> findOneRepository(String name){
        return repositoryRepository.findOneRepository(name);
    }

    public void createRepository(Repository repository) {
         repositoryRepository.createRepository(repository);
    }

    public void deleteRepository(String name){
        repositoryRepository.deleteRepository(name);
    }

    public void postIssue(Issue issue, String repository) {
        this.repositoryRepository.postIssue(issue, repository);
    }
}
