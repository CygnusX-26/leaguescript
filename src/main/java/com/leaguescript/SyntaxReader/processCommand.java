package com.leaguescript.SyntaxReader;

import java.util.Scanner;
import com.leaguescript.Items;
import com.leaguescript.Errors.BadGrammer;
import com.leaguescript.Errors.InvalidItemName;
import com.leaguescript.Keywords.Keyword;

public class processCommand {
    public void run(Keyword k, String[] args, Scanner s, int lineNum, Items varList, Cache cache) throws BadGrammer, InvalidItemName{
        k.run(args, s, lineNum, varList, cache);
    }
}
