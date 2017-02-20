/**
 * Created by vaibhavrupapara on 2/18/17.
 */
public class ThreadSync extends Thread{
    private  String stringValue;
    private int checkedPower;

    public synchronized int isCheckedPower() {
        return checkedPower;
    }

    public synchronized void setCheckedPower(int checkedPower) {
        this.checkedPower = checkedPower;
    }

    public synchronized String getStringValue() {

        return stringValue;
    }

    public synchronized void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    /**
     * It will take String binary and checks all subset occurence for Power of 5
     * and return Minimum Occurrence
     * It will return -1 incase Binary string start with "0" or No subset is Power of 5
     * @param s Binary String Ie. "101"
     * @return Ie. 1
     */

    private synchronized int getMin (String s){
        long [] f = new long [s.length() + 1] ;
        f[0] = 0;
        for (int i = 1 ; i <= s.length() ;++i) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 1 ; j <= i ;++j) {
                if (s.charAt(j - 1) == '0'){
                    continue ;
                }
                long num = Long.parseLong(s.substring(j - 1, i), 2) ;
               if (checkedPower(num)) {
                    f[i] = Math.min(f[i], f[j - 1] + 1) ;
                }
            }
        }
        return f[s.length()] == Integer.MAX_VALUE ? -1 : (int)f[s.length()] ;

    }

    /**
     * It checks if long value is Power of 5
     * @param value I.e long 5
     * @return I.e true
     */
    private synchronized boolean checkedPower(long value) {
        if (value == 0) {
            return false ;
        }
        int number = (int)(Math.log(value) / Math.log(5));
        return Math.pow(5, number) == value;
    }

    public void run(){
        checkedPower = getMin(stringValue);
    }
}
