package com.leaguescript.Keywords;

import java.util.Scanner;
import com.leaguescript.Items;
import com.leaguescript.Errors.BadGrammer;
import com.leaguescript.Errors.InvalidItemName;

/**
 * Basic comparative statement facecheck $var1 = $var2
 */
public class facecheck
    implements Keyword
{
    private void goNext (Scanner s) {
        while(!s.nextLine().startsWith("endcheck"));
    }
    @Override
    public void run(String[] args, Scanner s, int lineNum, Items varList)
        throws BadGrammer, InvalidItemName
    {
        /*
         * if (x=x || i=i) Boolean object -> var cond var 0: facecheck 1: var 2:
         * "=" 3: "var2"
         */
        // TODO, check if $var1 is not a valid Variable
        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("$")){
                args[i] = varList.getItem(args[i]);
            }
        }
        switch (args[2])
        {
            case "==":
                if (!(args[1].equals(args[3])))
                {
                    goNext(s);
                } 
                break;
            case ">":
                if (!(args[1].compareTo(args[3]) > 0))
                {
                    goNext(s);
                } 
                break;
            case "<":
                if (!(args[1].compareTo(args[3]) < 0))
                {
                    goNext(s);
                } 
                break;
            case ">=":
                if (!(args[1].compareTo(args[3]) >= 0))
                {
                    goNext(s);
                } 
                break;
            case "<=":
                if (!(args[1].compareTo(args[3]) <= 0))
                {
                    goNext(s);
                } 
                break;
            default:
                throw new BadGrammer("You lost CS at Line: " + lineNum);
        }
    }
}
