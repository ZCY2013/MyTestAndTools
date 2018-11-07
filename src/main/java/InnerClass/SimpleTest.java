package InnerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Date;

public class SimpleTest {
    private int interval;
    private boolean beep;

    public SimpleTest(int interval ,boolean beep){
        this.interval = interval;
        this.beep = beep;
    }
    public void start(){
        ActionListener listener = new TImerPrinter();
        Timer t = new Timer(interval, listener);
         t.start();
    }

    public class TImerPrinter implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("At the tone. the time is "+ new Date());
            if(beep) Toolkit.getDefaultToolkit();
        }
    }
}
