package org.example;
import java.lang.Runtime;

public class App {
    public static String getProperties(String arg) {
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
            System.out.println(getProperties(arg));
        }
    }
}
