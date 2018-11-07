package InnerClass;

import javax.swing.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class InnerClass{
    public static void main(String[] args) throws NoSuchAlgorithmException {
        SimpleTest simpleTest = new SimpleTest(1000, true);
        simpleTest.start();
        JOptionPane.showMessageDialog(null, "Quit Program");
        System.exit(0);
    }
}
