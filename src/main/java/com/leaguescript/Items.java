package com.leaguescript;

import java.util.HashMap;
import com.leaguescript.Errors.InvalidItemName;
import com.leaguescript.SyntaxReader.SyntaxReader;

public class Items {
    private HashMap<String, String> items = new HashMap<String, String>();
    public void storeItem(String s, String args){
        if (items.containsKey(s)){
            items.replace(s, args);
        }
        items.put(s, args);
    }
    public String getItem(String s) throws InvalidItemName{
        String item = items.get(s);
        if (!s.startsWith("$") || item == null){
            throw new InvalidItemName("That item doesn't exist lol at line: " + SyntaxReader.lineNuml);
        }
        return item;
    }
}
