package com.leaguescript.Keywords;

import java.util.ArrayList;
import java.util.Scanner;
import com.leaguescript.Items;
import com.leaguescript.Errors.BadGrammer;
import com.leaguescript.Errors.InvalidItemName;
import com.leaguescript.SyntaxReader.Cache;
import com.leaguescript.SyntaxReader.Operations;

/**
 * Basic comparative statement facecheck $var1 = $var2
 */
public class facecheck
    implements Keyword
{
    private void goNext (Scanner s) {
        while(!s.nextLine().startsWith("endcheck"));
    }

    private boolean parseOperator(Object arg1, Object arg2, String op, int lineNum) throws BadGrammer{
        switch (op){
            case "==":
            return Operations.equals(arg1, arg2);
            case "<":
            return Operations.isLess(arg1, arg2);
            case ">":
            return Operations.isMore(arg1, arg2);
            case "<=":
            return Operations.isLessOrEquals(arg1, arg2);
            case ">=":
            return Operations.isMoreOrEquals(arg1, arg2);
            case "!=":
            return Operations.isNotEquals(arg1, arg2);
            default:
            throw new BadGrammer("FF you put an invalid type in LMAO at line: " + lineNum);
        }
    }

    private Boolean parseLogic(Object object, Object object2, String logic, int lineNum) throws BadGrammer{
        switch (logic){
            case "||":
            return Operations.or(object, object2);
            case "&&":
            return Operations.and(object, object2);
            case "!=":
            return Operations.not(object, object2);
            default:
            throw new BadGrammer("Idfk what you did lmao at line: " + lineNum);

        }
    }
    private static boolean isNumeric(String str) { 
        try {  
          Double.parseDouble(str);  
          return true;
        } catch(NumberFormatException e){  
          return false;  
        }  
      }

    @Override
    public void run(String[] args, Scanner s, int lineNum, Items varList, Cache cache)
        throws BadGrammer, InvalidItemName
    {
        Boolean b = false;
        /*
         * if (x=x || i=i) Boolean object -> var cond var 0: facecheck 1: var 2:
         * "=" 3: "var2"
         */
        // TODO, check if $var1 is not a valid Variable
        ArrayList<Object> argsAsObj = new ArrayList<Object>();
        for (int i = 1; i < args.length; i ++){
            argsAsObj.add(args[i]);
        }
        for (int i = 1; i < args.length; i++) {
            if (args[i].startsWith("$")){
                if (varList.getItem(args[i]) == null){
                    throw new BadGrammer("Learn to spell at line: " + lineNum);
                }
                argsAsObj.set(i - 1, varList.getItem(args[i]));
            }
            else if (isNumeric(args[i])){
                argsAsObj.set(i-1, new Integer(args[i]));
            }
        }
        for (int i = 0; i < argsAsObj.size(); i ++){
            switch (i % 4){
                case 0:
                    cache.pushItemStack(argsAsObj.get(i));
                    break;
                case 1:
                    cache.pushOperatorStack((String)argsAsObj.get(i));
                    break;
                case 2:
                    cache.pushItemStack(argsAsObj.get(i));
                    cache.pushBoolStack(parseOperator(cache.popItemStack(), cache.popItemStack(), cache.popOperatorStack(), lineNum));
                    break;
                case 3:
                    //cache.pushBoolStack(parseOperator(cache.popItemStack(), cache.popItemStack(), cache.popOperatorStack(), lineNum));
                    cache.pushLogicStack((String)argsAsObj.get(i));
                    break;
            }
        }
        for (int i = 0; i < argsAsObj.size()/4; i ++){
            cache.pushBoolStack(parseLogic(cache.popBoolStack(), cache.popBoolStack(), cache.popLogicStack(), lineNum));
        }
        b = (Boolean)cache.popBoolStack();
        if (!b){
            goNext(s);
        }
    }
}
