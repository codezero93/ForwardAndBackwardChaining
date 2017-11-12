/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forwardandbackwardchaining;

/**
 *
 * @author Sam
 */
import java.util.ArrayList;
import java.util.List;

public class BackwardChaining extends AbstractChaining {

    public BackwardChaining(String queryStr, String kBase) {
        this.kBase = kBase;
        this.queryStr = queryStr;
        agList = new ArrayList<>();
        clList = new ArrayList<>();
        entList = new ArrayList<>();
        factList = new ArrayList<>();
        initialize(this.kBase);
    }

    @Override
    void initialize(String kBase) {
        agList.add(queryStr);
        String[] sentArr = kBase.split(";");
        for (int l = 0; l < sentArr.length; l++) {
            if (!sentArr[l].contains("=>")) {
                factList.add(sentArr[l]);
            } else {

                clList.add(sentArr[l]);
            }
        }
    }

    @Override //this is main algorithm
    boolean processEntailement() {
        while (!agList.isEmpty()) {
            String temp = agList.remove(agList.size() - 1);
            entList.add(temp);
            if (!factList.contains(temp)) {
                List<String> tempList = new ArrayList<>();
                for (int m = 0; m < clList.size(); m++) {
                    if (contains(clList.get(m), temp)) {
                        List<String> tempList2 = acquirePrem(clList.get(m));
                        for (int n = 0; n < tempList2.size(); n++) {
                            tempList.add(tempList2.get(n));
                        }
                    }
                }

                if (tempList.isEmpty()) {
                    return false;
                } else {
                    for (int m = 0; m < tempList.size(); m++) {
                        if (!entList.contains(tempList.get(m))) {
                            agList.add(tempList.get(m));
                        }
                    }

                }
            }

        }
        return true;
    }

   @Override
   public String getResult() {
        String result = "";

        if (processEntailement()) {

            result = "TRUE: ";

            for (int k = entList.size() - 1; k >= 0; k--) {
                if (k == 0) {
                    result += entList.get(k);
                } else {
                    result += entList.get(k) + ", ";
                }

            }
        } else {
            result = "FALSE";
        }
        return result;
    }

    public List<String> acquirePrem(String cl) {

        String premStr = cl.split("=>")[0];
        List<String> tempList = new ArrayList<>();
        String[] conjArr = premStr.split("&");

        for (int m = 0; m < conjArr.length; m++) {
            if (!agList.contains(conjArr[m])) {
                tempList.add(conjArr[m]);
            }
        }
        return tempList;
    }

    @Override
    boolean contains(String str1, String str2) {
        String concStr = str1.split("=>")[1];
        if (concStr.equals(str2)) {
            return true;
        } else {
            return false;
        }
    }

}
