package fr.paris8univ.iut.csid.csidwebrepositorybase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import fr.paris8univ.iut.csid.csidwebrepositorybase.RepositoryDao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class RepositoryRepository {

    private final RepositoryDao repositoryDao;

    @Autowired
    public RepositoryRepository(RepositoryDao repositoryDao){
        this.repositoryDao = repositoryDao;
    }

    public List<fr.paris8univ.iut.csid.csidwebrepositorybase.Repository> getRepositories() {
        List<RepositoryEntity> repositoriesEntity = repositoryDao.findAll();
        return repositoriesEntity.stream()
                .map(x -> new fr.paris8univ.iut.csid.csidwebrepositorybase.Repository(x.getName(),x.getOwner(),x.getIssues(), x.getPullRequest()))
                .collect(Collectors.toList());
    }

    public Optional<fr.paris8univ.iut.csid.csidwebrepositorybase.Repository> findOneRepository(String name){
        RepositoryEntity repoEntity = repositoryDao.findById(name).get();
        fr.paris8univ.iut.csid.csidwebrepositorybase.Repository repository =
                new fr.paris8univ.iut.csid.csidwebrepositorybase.Repository(
                        repoEntity.getName(), repoEntity.getOwner(), repoEntity.getIssues(), repoEntity.getPullRequest());
        return Optional.of(repository);
    }

    public void createRepository(fr.paris8univ.iut.csid.csidwebrepositorybase.Repository repository) {
        repositoryDao.save(
                new RepositoryEntity(repository.getName(), repository.getOwner(), repository.getIssues(), repository.getPullRequest()));
    }

    public void deleteRepository(String name){
        repositoryDao.deleteById(name);
    }

}
