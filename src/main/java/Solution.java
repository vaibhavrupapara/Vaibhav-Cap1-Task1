import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private ThreadSync threadSync;

    /**
     * ThreadSysc initialisation in Constructor so object is created once,
     * when method is called multiple times
     */
    public Solution(){
      threadSync = new ThreadSync();
    }

    /**
     * Calling ThreadSysnc synchronised Thread
     * @param s String binary I.e "101"
     * @return Minimum Power of 5 subset in String I.e 1
     */
    public int getMin(String s){

         threadSync.setStringValue(s);
         threadSync.start();
        try {
            threadSync.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return threadSync.isCheckedPower();

    }

}