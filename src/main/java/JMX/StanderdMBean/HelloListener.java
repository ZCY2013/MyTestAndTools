package JMX.StanderdMBean;

import javax.management.Notification;
import javax.management.NotificationListener;

public class HelloListener implements NotificationListener {
    @Override
    public void handleNotification(Notification notification, Object handback) {
        System.out.println("----------HelloListener-Begin------------");
        System.out.println("\ttype = "+ notification.getType());
        System.out.println("\tsource = "+notification.getSource());
        System.out.println("\tseq = "+notification.getSequenceNumber());
        System.out.println("\tsend time = "+notification.getTimeStamp());
        System.out.println("\tmessage="+notification.getMessage());
        System.out.println("----------HelloListener-End------------");

        if (handback != null) {
            if (handback instanceof Hello) {
                Hello hello = (Hello)handback;
                hello.printHello(notification.getMessage());
            }
            if(handback instanceof Client) System.out.println("handback is Client clazz");
        }else System.out.println("handback is null!");
    }
}
