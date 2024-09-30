package com.example.scheduling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExampleBatchFileRunner {

    public static void run(String[] args) {
        // Specify the path to the .bat file
        String batFilePath = "C:\\path\\to\\your\\file.bat";

        ProcessBuilder processBuilder = new ProcessBuilder(batFilePath);
        processBuilder.redirectErrorStream(true); // Redirect error stream to output stream

        try {
            Process process = processBuilder.start();

            // Read the output from the command
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }

            // Wait for the process to complete
            int exitCode = process.waitFor();
            System.out.println("Batch file executed with exit code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
	}

}
