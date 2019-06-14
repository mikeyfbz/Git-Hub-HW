import java.util.HashMap;

public class Account {

    private String name;
    private String username;
    private HashMap<String, Repo> repositories;
    private AccountType type;

    public Account(String name, String username, AccountType type){
        this.name = name;
        this.username = username;
        this.type = type;
        this.repositories = new HashMap<String, Repo>();
    }


    public String getName() {
        return this.name;
    }

    public String getUsername() {
        return this.username;
    }

    public String getAccountType() {
        return this.type.name();
    }

    public int getNumberOfRepositories() {
        return this.repositories.size();
    }

    public void addRepo(Repo repo) {
        this.repositories.put(repo.getName(), repo);
    }

    public void upgrade() {
        if(getAccountType() == "FREE"){
            this.type = AccountType.PRO;
        }
    }

    public void downGrade() {
        if(getAccountType() == "PRO"){
            this.type = AccountType.FREE;
        }
    }

    public Repo findRepoByName(String repoName) {
        Repo foundRepo = null;
        for (Repo repo:this.repositories.values()) {
            if(repo.getName() == repoName){
                foundRepo = repo;
            }
        }
        return foundRepo;
    }

    public Repo findRepoByLargestCommits() {
        Repo foundRepo = null;
        int commitCount = 0;
        for (Repo repo:this.repositories.values()) {
            if(repo.getNumberOfCommits() > commitCount){
                commitCount = repo.getNumberOfCommits();
                foundRepo = repo;
            }
        }
        return foundRepo;
    }
}
