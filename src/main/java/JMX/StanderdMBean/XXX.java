package JMX.StanderdMBean;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

public class XXX extends NotificationBroadcasterSupport implements XXXMBean {
    private int seq = 0;

    @Override
    public void hi() {
        Notification n = new Notification(
                "anonymousPerson",
                this,
                ++seq,
                System.currentTimeMillis(),
                "bello ciao"
        );
//        n = null;
        sendNotification(n);
    }
}
