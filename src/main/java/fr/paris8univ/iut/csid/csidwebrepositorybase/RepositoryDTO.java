package fr.paris8univ.iut.csid.csidwebrepositorybase;

public class RepositoryDTO {

    private final String name;
    private final String owner;
    private final int issues;
    private final int pullRequest;


    public RepositoryDTO(String name, String owner, int issues, int pullRequest) {
        this.name = name;
        this.owner = owner;
        this.issues = issues;
        this.pullRequest = pullRequest;
    }

    public String getName() {
        return this.name;
    }

    public String getOwner() {
        return this.owner;
    }

    public int getIssues() {
        return this.issues;
    }

    public int getPullRequest() {
        return this.pullRequest;
    }
}
