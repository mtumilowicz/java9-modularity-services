package client;

import factory.BotFactory;
import factory.LanguageNotSupportedException;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by mtumilowicz on 2018-05-12.
 */
public class Main {
    public static void main(String[] args) {
        String name;
        System.out.println("Bot languages: ");
        Arrays.stream(BotFactory.getSupportedLanguages())
                .forEach(x -> System.out.println("-- " + StringUtils.lowerCase(x.name())));
        do {
            System.out.println("Type language: ");

            Scanner scanner = new Scanner(System.in);
            name = scanner.nextLine();
            
            if (Objects.equals(name, "exit")) {
                break;
            }
            
            handleUserInput(name);
        } while (true);
    }
    
    private static void handleUserInput(String name) {
        try {
            BotFactory.get(name).greeting();
        } catch (LanguageNotSupportedException e) {
            System.out.println(e.getMessage());
        }
    }
}
