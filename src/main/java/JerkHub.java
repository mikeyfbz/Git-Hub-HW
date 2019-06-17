import java.util.ArrayList;

public class JerkHub {

    private String name;
    private ArrayList<Account> accountList;

    public JerkHub(String name){
        this.name = name;
        this.accountList = new ArrayList<Account>();
    }

    public String getName(){
        return this.name;
    }

    public int getNumberOfAccounts(){
        return this.accountList.size();
    }

    public void addAccount(Account account){
        this.accountList.add(account);
    }


    public void alphabetiseAccounts() {
        ArrayList<Account> sortedList = new ArrayList<Account>();
        ArrayList<String> names = new ArrayList<String>();
        for (Account account: this.accountList) {
            names.add(account.getName());
        }
        int n = this.accountList.size();
        String temp;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j + 1 < n; j++) {
                if(names.get(j).charAt(0) > names.get(j+1).charAt(0)){
                    temp = names.get(j);
                    names.set(j, names.get(j+1));
                    names.set(j+1, temp);
                }
            }
            System.out.println(names);
        }
        for (int i = 0; i < names.size(); i++) {
            for (Account account : this.accountList) {
                if (names.get(i) == account.getName()){
                    sortedList.add(account);
                }
            }
        }
        this.accountList = sortedList;
    }

    public ArrayList<Account> getListOfAccounts() {
        return this.accountList;
    }
}
