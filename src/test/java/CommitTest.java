import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CommitTest {

    Commit commit;

    @Before
    public void before(){
        commit = new Commit("added new feature", CommitType.FEATURE, 1);
    }

    @Test
    public void commitHasADescription(){
        assertEquals("added new feature", commit.getDescription());
    }

    @Test
    public void commitHasACommitType(){
        assertEquals("FEATURE", commit.getCommitType());
    }

    @Test
    public void commitHasAUniqueID(){
        assertEquals(1, commit.getUniqueID());
    }

}
