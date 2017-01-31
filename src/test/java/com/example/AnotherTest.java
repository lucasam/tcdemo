package com.example;

import java.util.Date;
import org.junit.Test;

/**
 * Created by sym on 31/01/17.
 */
public class AnotherTest {
    @Test
    public void dummy1() throws Exception {
        System.out.println(new Date() + " Dummy1 test executing");
        Thread.sleep(5000);
        System.out.println(new Date() + " Dummy1 test executed");
    }
}
