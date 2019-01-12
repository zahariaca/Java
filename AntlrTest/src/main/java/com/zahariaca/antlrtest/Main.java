package com.zahariaca.antlrtest;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try {
            CharStream charStream = CharStreams.fromFileName("test.file");
            ExprLexer exprLexer = new ExprLexer(charStream);
            CommonTokenStream commonTokenStream = new CommonTokenStream(exprLexer);
            ExprParser exprParser = new ExprParser(commonTokenStream);

            ParseTree parseTree = exprParser.expr();

            System.out.println(parseTree);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
