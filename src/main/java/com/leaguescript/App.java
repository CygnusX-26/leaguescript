package com.leaguescript;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import com.leaguescript.Errors.BadGrammer;
import com.leaguescript.Errors.InvalidItemName;
import com.leaguescript.SyntaxReader.SyntaxReader;

/**
 * Hello world!
 */
public final class App {

    /**
     * Starts a league script file.
     * @param args The arguments of the program.
     * @throws FileNotFoundException
     * @throws BadGrammer
     */
    public static void main(String[] args) throws FileNotFoundException, BadGrammer, InvalidItemName {
        File file = new File("script.lols");

        if (!file.exists()){
            System.exit(0);
        }

        Scanner s = new Scanner(file);

        new SyntaxReader().runCode(s);
        //start scanning
        //auto completes second line of comments lmao nice

    }
}
