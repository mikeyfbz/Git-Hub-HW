import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class GitHubTest {

    GitHub gitHub;
    Account account1;
    Account account2;
    Account account3;
    ArrayList<Account> accountList;

    @Before
    public void before(){
        account1 = new Account("Ben", "ben15", AccountType.FREE);
        account2 = new Account("Rory", "roryisgod", AccountType.FREE);
        account3 = new Account("Andrew", "coffeeman", AccountType.FREE);
        accountList = new ArrayList<Account>();
        gitHub = new GitHub("HUB");



    }

    @Test
    public void accountListStartsEmpty(){
        assertEquals(0, gitHub.getNumberOfAccounts());
    }



    @Test
    public void accountListCanBeAlphabetised(){
        ArrayList<Account> alphaArray = new ArrayList<Account>();
        alphaArray.add(account3);
        alphaArray.add(account1);
        alphaArray.add(account2);
        accountList.add(account1);
        accountList.add(account2);
        accountList.add(account3);
        assertEquals(alphaArray, gitHub.sortAccountsAlphabetically(accountList));
    }

}
