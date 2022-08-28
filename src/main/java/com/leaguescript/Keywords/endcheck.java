package com.leaguescript.Keywords;

import java.util.Scanner;
import com.leaguescript.Items;
import com.leaguescript.Errors.BadGrammer;
import com.leaguescript.Errors.InvalidItemName;
import com.leaguescript.SyntaxReader.Cache;

public class endcheck implements Keyword{

    @Override
    public void run(String[] args, Scanner s, int lineNum, Items varList, Cache cache)
        throws BadGrammer,
        InvalidItemName
    {}
    
}
