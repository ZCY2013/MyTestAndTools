package JMX.DynamicMBean;

import com.sun.jdmk.comm.HtmlAdaptorServer;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class DynamicAgent {
    public static void main(String[] args) throws Exception {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName helloName = new ObjectName("MyMBean:name=helloDynamic");
        HelloDynamic hello = new HelloDynamic();
        server.registerMBean(hello, helloName);

        ObjectName adapterName = new ObjectName("MyMBean:name=htmladapter");
        HtmlAdaptorServer adapter = new HtmlAdaptorServer();
        server.registerMBean(adapter, adapterName);
        adapter.start();
    }
}
