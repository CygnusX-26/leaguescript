package com.leaguescript.Keywords;

import java.util.Scanner;
import com.leaguescript.Items;
import com.leaguescript.Errors.BadGrammer;
import com.leaguescript.Errors.InvalidItemName;
import com.leaguescript.SyntaxReader.Cache;

public class openchat implements Keyword{
    /**
     * Prints Statement
     * @throws BadGrammer
     */
    @Override
    public void run(String[] args, Scanner s, int lineNum, Items varList, Cache cache) throws BadGrammer, InvalidItemName{
        if (args.length <= 0){
            throw new BadGrammer("Learn to spell at line: " + lineNum);
        }
        
        else{
            for (int i = 1; i < args.length; i ++){
                if (args[i].startsWith("$")){
                    System.out.print(varList.getItem(args[i]) + " ");
                }
                else{
                    System.out.print(args[i] + " ");
                }
                
            }
        }
        System.out.println();
    }
}
