import java.util.ArrayList;
import java.util.Collections;

public class GitHub {

    private ArrayList<Account> accounts;
    private String name;

    public GitHub(String name){
        this.accounts = new ArrayList<Account>();
        this.name = name;
    }

    public int getNumberOfAccounts(){
        return this.accounts.size();
    }

    public ArrayList<Account> sortAccountsAlphabetically(ArrayList<Account> accountList) {
        ArrayList<String> nameArray= new ArrayList<String>();
        ArrayList<Account> sortedAccounts = new ArrayList<Account>();
        for (Account account:accountList) {
            nameArray.add((account.getName()));
        }
        Collections.sort(nameArray);
        for (int i = 0; i < accountList.size(); i++) {
            for (Account account: accountList) {
                if(account.getName() == nameArray.get(i)){
                    sortedAccounts.add(account);
                }
            }
        }
        return sortedAccounts;
    }
}
