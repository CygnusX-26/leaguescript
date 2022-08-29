package com.leaguescript.SyntaxReader;

import java.util.Comparator;
import com.leaguescript.Errors.BadGrammer;

/**
 * All types of operations
 */
public class Operations {
    private static boolean isNumeric(Object arg2) {
        if (arg2 == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(arg2.toString());
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public static Boolean isLess(Object arg1, Object arg2) throws BadGrammer{
        if (arg1 instanceof Integer && arg2 instanceof Integer){
            return ((Integer)arg1).compareTo((Integer)arg2) > 0;
        }
        else if (arg1 instanceof String && arg2 instanceof String){
            return ((String)arg1).compareTo((String)arg2) > 0;
        }
        else{
            throw new BadGrammer("Those types of items cannot be compared!");
        }
    }
    public static Boolean isMore(Object arg1, Object arg2) throws BadGrammer{
        if (arg1 instanceof Integer && arg2 instanceof Integer){
            return ((Integer)arg1).compareTo((Integer)arg2) < 0;
        }
        else if (arg1 instanceof String && arg2 instanceof String){
            return ((String)arg1).compareTo((String)arg2) < 0;
        }
        else{
            throw new BadGrammer("Those types of items cannot be compared!");
        }
    }
    public static Boolean equals(Object arg1, Object arg2) throws BadGrammer{
        if (arg1 instanceof Integer && arg2 instanceof Integer){
            return ((Integer)arg1).equals((Integer)arg2);
        }
        else if (arg1 instanceof String && arg2 instanceof String){
            return ((String)arg1).equals((String)arg2);
        }
        else{
            throw new BadGrammer("Those types of items cannot be compared!");
        }
    }
    public static Boolean isLessOrEquals(Object arg1, Object arg2) throws BadGrammer{
        if (arg1 instanceof Integer && arg2 instanceof Integer){
            return ((Integer)arg1).compareTo((Integer)arg2) >= 0;
        }
        else if (arg1 instanceof String && arg2 instanceof String){
            return ((String)arg1).compareTo((String)arg2) >= 0;
        }
        else{
            throw new BadGrammer("Those types of items cannot be compared!");
        }
    }
    public static Boolean isMoreOrEquals(Object arg1, Object arg2) throws BadGrammer{
        if (arg1 instanceof Integer && arg2 instanceof Integer){
            return ((Integer)arg1).compareTo((Integer)arg2) <= 0;
        }
        else if (arg1 instanceof String && arg2 instanceof String){
            return ((String)arg1).compareTo((String)arg2) <= 0;
        }
        else{
            throw new BadGrammer("Those types of items cannot be compared!");
        }
    }
    public static Boolean isNotEquals(Object arg1, Object arg2) throws BadGrammer{
        if (arg1 instanceof Integer && arg2 instanceof Integer){
            return ((Integer)arg1).compareTo((Integer)arg2) != 0;
        }
        else if (arg1 instanceof String && arg2 instanceof String){
            return ((String)arg1).compareTo((String)arg2) != 0;
        }
        else{
            throw new BadGrammer("Those types of items cannot be compared!");
        }
    }

    public static Boolean or(Object arg1, Object arg2) throws BadGrammer{
        if (arg1 instanceof Boolean && arg2 instanceof Boolean){
            return ((Boolean)arg1 || (Boolean)arg2);
        }
        else{
            throw new BadGrammer("Those must be booleans fool");
        }
    }

    public static Boolean and(Object arg1, Object arg2) throws BadGrammer{
        if (arg1 instanceof Boolean && arg2 instanceof Boolean){
            return ((Boolean)arg1 && (Boolean)arg2);
        }
        else{
            throw new BadGrammer("Those must be booleans fool");
        }
    }

    public static Boolean not(Object arg1, Object arg2) throws BadGrammer{
        if (arg1 instanceof Boolean && arg2 instanceof Boolean){
            return ((Boolean)arg1 != (Boolean)arg2);
        }
        else{
            throw new BadGrammer("Those must be booleans fool");
        }
    }

    public static String add(Object arg1, Object arg2){
        if (isNumeric(arg1) && isNumeric(arg2)){
            return ((Integer)arg1 + (Integer)arg2) + "";
        }
        else{
            return arg1.toString() + arg2.toString();
        }
    }
    public static Integer sub(Object arg1, Object arg2){
        return ((Integer)arg1 - (Integer)arg2);
    }
    public static Integer mul(Object arg1, Object arg2){
        return ((Integer)arg1 * (Integer)arg2);
    }
    public static Integer div(Object arg1, Object arg2){
        return ((Integer)arg1 / (Integer)arg2);
    }
    public static Integer mod(Object arg1, Object arg2){
        return ((Integer)arg1 % (Integer)arg2);
    }
}
