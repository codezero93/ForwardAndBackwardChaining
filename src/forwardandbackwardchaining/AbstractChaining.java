/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forwardandbackwardchaining;

import java.util.List;

/**
 *
 * @author Sam
 */
public abstract class AbstractChaining {

    public String kBase;
    public String queryStr;
    public List<String> agList;
    public List<String> factList;
    public List<String> clList;
    public List<String> entList;
    public List<Integer> total;

    abstract void initialize(String kBase);

    abstract boolean processEntailement();

    abstract String getResult();

    abstract boolean contains(String str1, String str2);
}
