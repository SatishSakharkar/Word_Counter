/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package word.counter;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 'text' to input text manually or 'file' to provide a file path:");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("text")) {
            System.out.println("Enter the text:");
            String inputText = scanner.nextLine();
            int wordCount = countWords(inputText);
            System.out.println("Total word count: " + wordCount);
        } else if (choice.equalsIgnoreCase("file")) {
            System.out.println("Enter the file path:");
            String filePath = scanner.nextLine();
            try {
                File file = new File(filePath);
                Scanner fileScanner = new Scanner(file);
                String fileContent = "";
                while (fileScanner.hasNextLine()) {
                    fileContent += fileScanner.nextLine() + " ";
                }
                fileScanner.close();
                int wordCount = countWords(fileContent);
                System.out.println("Total word count: " + wordCount);
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
            }
        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }

    public static int countWords(String text) {
        String[] words = text.split("[\\s\\p{Punct}]+");
        return words.length;
    }
}
