package org.example.infrastructure.io;

import org.example.application.io.Printer;

public class CommandLinePrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
