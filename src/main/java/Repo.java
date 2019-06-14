import java.util.ArrayList;

public class Repo {

    private String name;
    private String repoDescription;
    private Enum repoType;
    private ArrayList<Commit> commits;
    private ArrayList<Commit> foundCommits;

    public Repo(String name, String repoDescription, Enum repoType){
        this.name = name;
        this.repoDescription = repoDescription;
        this.repoType = repoType;
        this.commits = new ArrayList<Commit>();
        this.foundCommits = new ArrayList<Commit>();
    }

    public String getName(){
        return this.name;
    }

    public int getLastUsedID(){
        int index = this.commits.size();
        int IDNumber = this.commits.get(index - 1).getUniqueID();
        return IDNumber;
    }

    public String getDescription() {
        return this.repoDescription;
    }

    public String getRepoType() {
        return this.repoType.name();
    }

    public int getNumberOfCommits() {
        return this.commits.size();
    }

    public void addCommit(Commit commit) {
        this.commits.add(commit);
    }

    public Commit findCommitByID(int uniqueID) {
        Commit foundCommit = null;
        for (Commit commit:this.commits) {
            if(commit.getUniqueID() == uniqueID){
                foundCommit = commit;
            }
        }
        return foundCommit;
    }

    public ArrayList<Commit> findCommitByType(String repoType) {
        for (Commit commit:this.commits) {
            if(commit.getCommitType() == repoType){
                foundCommits.add(commit);
            }
        }
        return foundCommits;
    }

    public void revert(int commitID) {
        ArrayList<Commit> commitsToRemove = new ArrayList<Commit>();
        for (Commit commit:this.commits) {
            if(commit.getUniqueID() > commitID){
                commitsToRemove.add(commit);
            }
        }
        for (Commit commit : commitsToRemove) {
            this.commits.remove(commit);
        }
    }
}
