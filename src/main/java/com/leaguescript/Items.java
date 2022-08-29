package com.leaguescript;

import java.util.HashMap;
import com.leaguescript.Errors.BadGrammer;
import com.leaguescript.Errors.InvalidItemName;
import com.leaguescript.SyntaxReader.SyntaxReader;

public class Items {
    private HashMap<String, Object> items = new HashMap<String, Object>();
    public void storeItem(String s, String args, String type) throws BadGrammer{
        if (type.equals("int")){
            try{
                items.put(s, (Integer)Integer.parseInt(args));
            }
            catch (NumberFormatException e){
                throw new BadGrammer("Cannot fit an item of that type into an item of type: " + type);
            }
            
        }
        else if (type.equals("str")){
            items.put(s, args);
        }
        else if (type.equals("bool")){
            items.put(s, Boolean.parseBoolean(args));
        }
        
    }
    public Object getItem(String s) throws InvalidItemName{
        Object item = items.get(s);
        if (!s.startsWith("$") || item == null){
            throw new InvalidItemName("That item doesn't exist lol at line: " + SyntaxReader.lineNuml);
        }
        return item;
    }
}
