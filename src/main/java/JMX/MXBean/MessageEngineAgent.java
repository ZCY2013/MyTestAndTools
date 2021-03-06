package JMX.MXBean;

import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class MessageEngineAgent {
    public void start() {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        try{
            MessageEngine me = new MessageEngine();
            ObjectName mxbeanName = new ObjectName(me.getClass() + "=MessageEngine");
            MessageEngineMXBean mxbean = new MessageEngine();
            mbs.registerMBean(mxbean, mxbeanName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
