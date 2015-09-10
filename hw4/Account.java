// Account.java
//Gavin Leith gdl386
    public class Account implements Comparable<Account> {
        private String name;
        private Integer amount;
        public Account(String nm, Integer amt) {
            name = nm;
            amount = amt; }
        public static Account account(String nm, Integer amt) {
            return new Account(nm, amt); }
        public String name() { return name; }
        public Integer amount() { return amount; }
        public boolean equals(Object x) {
            if ( x == null ) return false;
            else if ( getClass() != x.getClass() ) return false;
            else return name.equals( ((Account)x).name); }

        // return -1 to sort this account before x, else 1
        public int compareTo(Account x) {
	int ans;
	if(this.name.equals(x.name))
		ans=0;
	else if(this.name.compareTo(x.name)>0){
		ans=1;
	}
	else ans = -1;
	if(ans==0){
		if(x.amount<0&&this.amount<0){
			ans=this.amount-x.amount;
		}
		else ans=x.amount-this.amount;
		//System.out.println(this.amount+"||"+x.amount);	
	}
	return ans;
    }
        public String toString() {
            return ( "(" + this.name + " " + this.amount + ")"); }
    }
