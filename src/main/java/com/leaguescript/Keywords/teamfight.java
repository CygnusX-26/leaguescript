package com.leaguescript.Keywords;

import java.util.Scanner;
import com.leaguescript.Items;
import com.leaguescript.Errors.BadGrammer;
import com.leaguescript.Errors.InvalidItemName;
import com.leaguescript.SyntaxReader.Cache;

public class teamfight implements Keyword{
    /**
     * takes user input
     * @throws InvalidItemName
     */
    @Override
    public void run(String[] args, Scanner s, int lineNum, Items varList, Cache cache) throws BadGrammer, InvalidItemName{
        if(args.length < 4){
            throw new BadGrammer("YOU CANT GROUP LIKE THAT at line: " + lineNum);
        }
        if (!args[args.length - 1].startsWith("$")){
            throw new BadGrammer("ITEM NAMES MUST START WITH $ at line: " + lineNum);
        }
        String temp = "";
        for (int i = 1; i < args.length-1; i++){
            if (args[i].startsWith("$")){
                temp += varList.getItem(args[i]);
            }
            else{
                temp += args[i];
            }
        }
        // varList.storeItem(args[args.length - 1], temp);
    }
}
