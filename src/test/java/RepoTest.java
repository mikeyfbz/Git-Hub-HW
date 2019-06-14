import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class RepoTest {

    Repo repo;
    Commit commitFeature;
    Commit commitBugfix;
    Commit commitRefactor;
    ArrayList<Commit> commits;
    ArrayList<Commit> foundCommits;

    @Before
    public void before(){
        repo = new Repo("Snowman", "Hangman type game", RepoType.PUBLIC);
        commitFeature = new Commit("added new feature", CommitType.FEATURE, 1);
        commitBugfix = new Commit("fixed bug", CommitType.BUGFIX, 2);
        commitRefactor = new Commit("refactored", CommitType.REFACTOR, 3);
        commits = new ArrayList<Commit>();
        foundCommits = new ArrayList<Commit>();
        commits.add(commitFeature);
        foundCommits.add(commitFeature);
    }

    @Test
    public void repoHasAName(){
        assertEquals("Snowman", repo.getName());
    }

    @Test
    public void repoHasADescription(){
        assertEquals("Hangman type game", repo.getDescription());
    }

    @Test
    public void repoHasARepoType(){
        assertEquals("PUBLIC", repo.getRepoType());
    }

    @Test
    public void repoStartsWithNoCommits(){
        assertEquals(0, repo.getNumberOfCommits());
    }

    @Test
    public void repoCanAddACommit(){
        repo.addCommit(commitBugfix);
        assertEquals(1, repo.getNumberOfCommits());
    }

    @Test
    public void repoCanFindCommitByID(){
        repo.addCommit(commitFeature);
        repo.addCommit(commitBugfix);
        assertEquals(commitFeature, repo.findCommitByID(1));
    }

    @Test
    public void repoReturnsNullIfIDDoesNotExist(){
        assertEquals(null, repo.findCommitByID(1));
    }

    @Test
    public void repoCanFindCommitByType(){
        repo.addCommit(commitFeature);
        assertEquals(foundCommits, repo.findCommitByType("FEATURE"));
    }

    @Test
    public void repoCanFindLastUsedID(){
        repo.addCommit(commitFeature);
        assertEquals(1, repo.getLastUsedID());
    }

    @Test
    public void repoCanRollBackToPreviousCommit(){
        repo.addCommit(commitFeature);
        repo.addCommit(commitBugfix);
        repo.addCommit(commitRefactor);
        repo.revert(2);
        assertEquals(2, repo.getNumberOfCommits());
    }

}
