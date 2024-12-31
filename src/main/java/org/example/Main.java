package org.example;

import antlr4.GoLangLexer;
import antlr4.GoLangParser;
import antlr4.Visitor;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "input3.go";
        String fileContents = readText(fileName);
        ANTLRInputStream inputStream = new ANTLRInputStream(fileContents);
        GoLangLexer lexer = new GoLangLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GoLangParser parser = new GoLangParser(tokens);

        GoLangParser.ProgramContext programContext = parser.program();
        Visitor visitor = new Visitor();
        visitor.visit(programContext);
    }

    public static String readText(String fileName) throws IOException {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            return lines.stream().collect(Collectors.joining(System.lineSeparator()));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
