package fr.paris8univ.iut.csid.csidwebrepositorybase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "repository")
public class RepositoryEntity {
    @Id
    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "owner")
    private String owner;

    @Column(name = "issues")
    private Integer issues;

    @Column(name = "pullRequest")
    private Integer pullRequest;

    public RepositoryEntity() {}

    public RepositoryEntity(String name,String owner, Integer issues,Integer pullRequest) {
        this.name=name;
        this.owner=owner;
        this.issues=issues;
        this.pullRequest=pullRequest;
    }

    public Integer getIssues() {
        return issues;
    }

    public void setIssues(Integer issues) {
        this.issues = issues;
    }

    public Integer getPullRequest() {
        return pullRequest;
    }

    public void setPullRequest(Integer pullRequest) {
        this.pullRequest = pullRequest;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner=owner;
    }
}