package com.leaguescript.Keywords;

import java.util.Scanner;
import com.leaguescript.Items;
import com.leaguescript.Errors.BadGrammer;
import com.leaguescript.Errors.InvalidItemName;
import com.leaguescript.SyntaxReader.Cache;
import com.leaguescript.SyntaxReader.Operations;

public class item implements Keyword{

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    private Object parseCalculation(Object arg1, Object arg2, String op, int lineNum) throws BadGrammer{
        switch (op){
            case "+":
            return Operations.add(arg1, arg2);
            case "-":
            return Operations.sub(arg1, arg2);
            case "*":
            return Operations.mul(arg1, arg2);
            case "/":
            return Operations.div(arg1, arg2);
            case "%":
            return Operations.mod(arg1, arg2);
            default:
            throw new BadGrammer("Idfk what you did lmao at line: " + lineNum);
        }
    }
    /**
     * Store a variable value
     * @throws InvalidItemName
     */
    @Override
    public void run(String[] args, Scanner s, int lineNum, Items varList, Cache cache) throws BadGrammer, InvalidItemName
    {
        String operators = "+-*/%";
        String[] typeIdentifier = args[args.length-1].split(":");
        if (args.length < 3){
            throw new BadGrammer("Learn to spell at line: " + lineNum);
        }
        else if (args[2].startsWith("teamfight")){
            Scanner scan = new Scanner(System.in);
                varList.storeItem(args[1], scan.nextLine(), typeIdentifier[1]);        
            }
        else if (args.length == 3){
            varList.storeItem(args[1], typeIdentifier[0], typeIdentifier[1]);
        }
        else{
            args[args.length - 1] = typeIdentifier[0];
            for (int i = 2; i < args.length; i ++){
                if (isNumeric(args[i])){
                    cache.pushNumbersStack(Integer.parseInt(args[i]));
                }
                else if (operators.contains(args[i])){
                    cache.pushOperatorStack(args[i]);
                }
                else if (args[i].startsWith("$")){
                    cache.pushNumbersStack(varList.getItem(args[i]));
                }
                else{
                    throw new BadGrammer("Learn to spell at line: " + lineNum);
                }
            }
            for (int i = 0; i < cache.getOperatorStack().size(); i ++){
                cache.pushNumbersStack(parseCalculation(cache.popNumbersStack(), cache.popNumbersStack(), cache.popOperatorStack(), lineNum));
            }
            varList.storeItem(args[1], cache.popNumbersStack().toString(), typeIdentifier[1]);
        }
        
    }
    
}
