package com.esgi;

import org.junit.Test;

public class Tests {
    @Test
    public void testAdditionNoLog(){
        Main.main(new String[]{"input.txt", "+"});
    }

    @Test
    public void testAdditionLog(){
        Main.main(new String[]{"input.txt", "+", "-log"});
    }

    @Test
    public void testSoustractionNoLog(){
        Main.main(new String[]{"input.txt", "-"});
    }

    @Test
    public void testSoustractionLog(){
        Main.main(new String[]{"input.txt", "-", "-log"});
    }

    @Test
    public void testMultiplicationNoLog(){
        Main.main(new String[]{"input.txt", "*"});
    }

    @Test
    public void testMultiplicationLog(){
        Main.main(new String[]{"input.txt", "*", "-log"});
    }
}
