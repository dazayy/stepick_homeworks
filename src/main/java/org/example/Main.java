package org.example;

import core.BaseTest;
import org.junit.jupiter.api.Test;
import pages.Page1;

public class Main extends BaseTest {

    @Test
    public void checkPage() {
        Page1 p1 = new Page1();

        p1.getPage();
    }

    public static void main(String[] args) {

    }
}