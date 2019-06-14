import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;

public class AccountTest {

    Account account;
    Repo repo;
    Repo noCommitRepo;
    Commit commitFeature;
    Commit commitBugfix;
    HashMap<String, Repo> repositories;

    @Before
    public void before(){
        account = new Account("mikeyfbz", "Michael", AccountType.FREE);
        repo = new Repo("Snowman", "Hangman type game", RepoType.PUBLIC);
        noCommitRepo = new Repo("Scabble", "Word game", RepoType.PUBLIC);
        commitFeature = new Commit("added new feature", CommitType.FEATURE, 1);
        commitBugfix = new Commit("fixed bug", CommitType.BUGFIX, 2);
        repositories = new HashMap<String, Repo>();
        repo.addCommit(commitFeature);
        repo.addCommit(commitBugfix);
    }

    @Test
    public void accountHasAName(){
        assertEquals("mikeyfbz", account.getName());
    }

    @Test
    public void accountHasAUsername(){
        assertEquals("Michael", account.getUsername());
    }

    @Test
    public void accountHasAAccountType(){
        assertEquals("FREE", account.getAccountType());
    }

    @Test
    public void accountStartsWithAnEmptyRepositoryHash(){
        assertEquals(0, account.getNumberOfRepositories());
    }

    @Test
    public void accountCanAddARepoToRepositories(){
        account.addRepo(repo);
        assertEquals(1, account.getNumberOfRepositories());
    }

    @Test
    public void accountCanBeUpgraded(){
        account.upgrade();
        assertEquals("PRO", account.getAccountType());
    }

    @Test
    public void accountCanBeDownGraded(){
        account.downGrade();
        assertEquals("FREE", account.getAccountType());
    }

    @Test
    public void accountCanFindRepoByName(){
        account.addRepo(repo);
        assertEquals(repo, account.findRepoByName("Snowman"));
    }

    @Test
    public void accountCanFindRepoByLargestNumberOfCommits(){
        account.addRepo(repo);
        account.addRepo(noCommitRepo);
        assertEquals(repo, account.findRepoByLargestCommits());
    }

}
