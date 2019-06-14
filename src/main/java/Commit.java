import java.util.ArrayList;

public class Commit {

    private String description;
    private CommitType commitType;
    private Integer uniqueID;

    public Commit(String description, CommitType commitType, Integer uniqueID){
        this.description = description;
        this.commitType = commitType;
        this.uniqueID = uniqueID;
    }

    public String getDescription(){
        return this.description;
    }

    private int getUnique() {
        return 1;
    }

    public String getCommitType() {
        return this.commitType.name();
    }

    public int getUniqueID() {
        return this.uniqueID;
    }
}
