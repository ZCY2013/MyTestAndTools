package JMX.MXBean;

import javax.management.*;

public class MessageEngine extends NotificationBroadcasterSupport implements MessageEngineMXBean {
    private final Message message = Echo.msg;
    private long sequenceNumber = 1;

    public MessageEngine() {
        addNotificationListener(new NotificationListener() {
            @Override
            public void handleNotification(Notification notification, Object handback) {
                System.out.println("*** Handling new notification ***");
                System.out.println("Message: " + notification.getMessage());
                System.out.println("Seq: " + notification.getSequenceNumber());
                System.out.println("*********************************");
            }
        }, null, null);

    }

    @Override
    public void stop() {
        Echo.running = false;
    }

    @Override
    public boolean isPaused() {
        return Echo.pause;
    }

    @Override
    public void pause(boolean pause) {
        Echo.pause = true;
    }

    @Override
    public Message getMessage() {
        return this.message;
    }

    @Override
    public void changeMessage(Message m) {
        this.message.setBody(m.getBody());
        this.message.setTitle(m.getTitle());
        this.message.setBody(m.getBy());
    }

    @Override
    public MBeanNotificationInfo[] getNotificationInfo() {
        String[] types = new String[]{
                AttributeChangeNotification.ATTRIBUTE_CHANGE
        };

        String name = AttributeChangeNotification.class.getName();
        String description = "An attribute of this MBean has changed";
        MBeanNotificationInfo info = new MBeanNotificationInfo(types, name, description);
        return new MBeanNotificationInfo[0];
    }
}
