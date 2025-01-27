package org.example;
import java.lang.Runtime;
/**
 * @author Devin Schutz
 * This program gives the user information about their system based on what they request.
 */
public class App {
    /**
     * Returns the requested information from the user
     * @param arg - The requested information type
     * @return - THe requested information
     */
    public static String getProperties(String arg) {
        // this will give us CPU and memory stats
        Runtime runtime = Runtime.getRuntime();
        switch (arg) {
            case "-mem":
                String freeMem = String.format("Free Memory        : %,d", runtime.freeMemory());
                String totalMem = String.format("Total Memory       : %,d", runtime.totalMemory());
                String maxMem = String.format("Max Memory         : %,d", runtime.maxMemory());
                return freeMem + "\n" + totalMem + "\n" + maxMem;
            case "-cpu":
                return "Processors         : " + runtime.availableProcessors();
            case "-dirs":
                return "Working Directory  : " + System.getProperty("user.dir") +
                        "\nUser Home Directory: " + System.getProperty("user.home");
            case "-os":
                return "OS Name            : " + System.getProperty("os.name") +
                        "\nOS Version         : " + System.getProperty("os.version");
            case "-java":
                return "Java Vendor        : " + System.getProperty("java.vendor") +
                        "\nJava Runtime       : " + System.getProperty("java.runtime.name") + 
                        "\nJava Version       : " + System.getProperty("java.version") +
                        "\nJava VM Version    : " + System.getProperty("java.vm.version") +
                        "\nJava VM Name       : " + System.getProperty("java.vm.name");
            default:
                return "";
        }
    }

    public static void main(String[] args) {
        for (String arg : args) {
           String output = getProperties(arg);
            if (output == "") { 
                continue; // don't print anything at all if we don't recognize the argument
            } else {
                System.out.println(output); // print out the desired output
            }
        }
    }
}
