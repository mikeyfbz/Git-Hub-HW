import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class JerkHubTest {

    JerkHub jerkHub;
    ArrayList<Account> accountsList;
    Account account1;
    Account account2;
    Account account3;

    @Before
    public void before(){
        jerkHub = new JerkHub("LikeGitButDifferent");
        account1 = new Account("Ben", "ben15", AccountType.FREE);
        account2 = new Account("John", "john12", AccountType.FREE);
        account3 = new Account("Tom", "tom19", AccountType.FREE);
        accountsList = new ArrayList<Account>();
    }

    @Test
    public void jeckHubStartsWithNoAccounts(){
        assertEquals(0, jerkHub.getNumberOfAccounts());
    }

    @Test
    public void jerkHubHasAName(){
        assertEquals("LikeGitButDifferent", jerkHub.getName());
    }

    @Test
    public void accountCanBeAddedToJerkHub(){
        jerkHub.addAccount(account1);
        assertEquals(1, jerkHub.getNumberOfAccounts());
    }

    @Test
    public void jerkHubCanGetListOfAllAccounts(){
        ArrayList<Account> alphaList = new ArrayList<Account>();
        alphaList.add(account1);
        alphaList.add(account2);
        alphaList.add(account3);
        jerkHub.addAccount(account1);
        jerkHub.addAccount(account2);
        jerkHub.addAccount(account3);
        assertEquals(alphaList, jerkHub.getListOfAccounts());
    }

    @Test
    public void jerkHubCanAlphabetiseAccounts(){
        jerkHub.addAccount(account2);
        jerkHub.addAccount(account3);
        jerkHub.addAccount(account1);
        ArrayList<Account> alphaList = new ArrayList<Account>();
        alphaList.add(account1);
        alphaList.add(account2);
        alphaList.add(account3);
        jerkHub.alphabetiseAccounts();
        assertEquals(alphaList, jerkHub.getListOfAccounts());
    }
}
