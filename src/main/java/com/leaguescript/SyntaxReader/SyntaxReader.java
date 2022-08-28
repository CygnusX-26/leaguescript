package com.leaguescript.SyntaxReader;

import java.util.HashMap;
import java.util.Scanner;
import com.leaguescript.Items;
import com.leaguescript.Errors.BadGrammer;
import com.leaguescript.Errors.InvalidItemName;
import com.leaguescript.Keywords.Keyword;
import com.leaguescript.Keywords.facecheck;
import com.leaguescript.Keywords.teamfight;
import com.leaguescript.Keywords.item;
import com.leaguescript.Keywords.openchat;
import com.leaguescript.Keywords.endcheck;

public class SyntaxReader {
    private HashMap<String, Keyword> h;
    private Items varList;
    public static int lineNuml;

    public SyntaxReader(){
        h = new HashMap<String, Keyword>();
        h.put("facecheck", new facecheck());
        h.put("teamfight", new teamfight());
        h.put("openchat", new openchat());
        h.put("item", new item());
        h.put("endcheck", new endcheck());
        varList = new Items();
        SyntaxReader.lineNuml = 0;
    }
    public void runCode(Scanner s) throws BadGrammer, InvalidItemName{

        while(s.hasNextLine()){
            String theLine = s.nextLine();
            String[] line = theLine.split(" ");
            if (line[0].startsWith("?")){ // If Comment
                continue;
            }
            else if (line[0].equals("")){ // if Empty Line
                continue;
            }
            else if (h.containsKey(line[0])){
                new processCommand().run(h.get(line[0]), line, s, lineNuml, varList);
            } 
            else{
                throw new BadGrammer("Learn to spell at line: " + lineNuml);
            }
            lineNuml ++;
        }
        
    }
}
