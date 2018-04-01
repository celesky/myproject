package com.designpattern;

import java.io.*;

public class Decorator {
    /* test.txt内容：
     * hello world!
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DataOutputStream dout = new DataOutputStream(new BufferedOutputStream((new FileOutputStream("c://file.txt"))));
    }
}
