package com.leaguescript.Keywords;

import java.util.Scanner;
import com.leaguescript.Items;
import com.leaguescript.Errors.BadGrammer;
import com.leaguescript.SyntaxReader.Cache;

public class item implements Keyword{

    /**
     * Store a variable value
     */
    @Override
    public void run(String[] args, Scanner s, int lineNum, Items varList, Cache cache) throws BadGrammer
    {
        String[] typeIdentifier = args[2].split(":");
        if (args.length < 3){
            throw new BadGrammer("Learn to spell at line: " + lineNum);
        }
        varList.storeItem(args[1], typeIdentifier[0], typeIdentifier[1]);
    }
    
}
