/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forwardandbackwardchaining;
import java.util.ArrayList;
import java.util.Arrays;

public class ForwardChaining extends AbstractChaining {

    public ForwardChaining(String queryStr, String kBase) {
        this.kBase = kBase;
        this.queryStr = queryStr;
        agList = new ArrayList<>();
        clList = new ArrayList<>();
        entList = new ArrayList<>();
        factList = new ArrayList<>();
        total = new ArrayList<>();
        initialize(this.kBase);
    }

    @Override
    void initialize(String kBase) {
        String[] sentArr = kBase.split(";");
        for (int m = 0; m < sentArr.length; m++) {

            if (!sentArr[m].contains("=>")) {
                agList.add(sentArr[m]);
            } else {

                clList.add(sentArr[m]);
                total.add(sentArr[m].split("&").length);
            }
        }
    }

    @Override //this is main algorithm
    boolean processEntailement() {

        while (!agList.isEmpty()) {
            String temp = agList.remove(0);
            entList.add(temp);
            for (int m = 0; m < clList.size(); m++) {
                if (contains(clList.get(m), temp)) {
                    int n = total.get(m);
                    total.set(m, --n);
                    if (total.get(m) == 0) {
                        String front = clList.get(m).split("=>")[1];
                        if (front.equals(queryStr)) {
                            return true;
                        }
                        agList.add(front);
                    }
                }
            }
        }

        return false;
    }

    @Override
    public String getResult() {
        String result = "";
        if (processEntailement()) {
            result = "TRUE: ";
            for (int m = 0; m < entList.size(); m++) {
                result += entList.get(m) + ", ";
            }
            result += queryStr;
        } else {
            result = "FALSE";
        }
        return result;
    }

    @Override
    public boolean contains(String str1, String str2) {
        String premStr = str1.split("=>")[0];
        String[] conjArr = premStr.split("&");

        if (conjArr.length == 1) {
            return premStr.equals(str2);
        } else {
            return Arrays.asList(conjArr).contains(str2);
        }
    }

}

