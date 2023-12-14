package ru.vavtech.hw3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

@Service
public class StreamsIOService implements IOService {
    private static final int MAX_ATTEMPTS = 10;

    private final PrintStream printStream;

    private final Scanner scanner;

    private final MessageSource messageSource;

    public StreamsIOService(
            @Value("#{T(System).out}") PrintStream printStream,
            @Value("#{T(System).in}") InputStream inputStream,
            MessageSource messageSource) {
        this.printStream = printStream;
        this.scanner = new Scanner(inputStream);
        this.messageSource = messageSource;
    }

    @Override
    public void printLine(String s) {
        String message = messageSource.getMessage(s, new Object[]{}, LocaleContextHolder.getLocale());
        printStream.println(message);
    }

    @Override
    public void printFormattedLine(String s, Object... args) {
        String formattedString = messageSource.getMessage(s, args, LocaleContextHolder.getLocale());
        printStream.println(formattedString);
    }

    @Override
    public String readString() {
        return scanner.nextLine();
    }

    @Override
    public String readStringWithPrompt(String prompt) {
        printLine(prompt);
        return scanner.nextLine();
    }

    @Override
    public int readIntForRange(int min, int max, String errorMessage) {
        for (int i = 0; i < MAX_ATTEMPTS; i++) {
            try {
                var stringValue = scanner.nextLine();
                int intValue = Integer.parseInt(stringValue);
                if (intValue < min || intValue > max) {
                    throw new IllegalArgumentException();
                }
                return intValue;
            } catch (IllegalArgumentException e) {
                printLine(errorMessage);
            }
        }
        throw new IllegalArgumentException("Error during reading int value");
    }

    @Override
    public int readIntForRangeWithPrompt(int min, int max, String prompt, String errorMessage) {
        printLine(prompt);
        return readIntForRange(min, max, errorMessage);
    }
}
