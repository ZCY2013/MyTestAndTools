package JMX.CommonModeler;

import com.sun.jdmk.comm.HtmlAdaptorServer;
import org.apache.commons.modeler.ManagedBean;
import org.apache.commons.modeler.Registry;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.modelmbean.ModelMBean;
import java.io.InputStream;

public class CommonAgent {
    public static void main(String[] args) throws Exception {
        Registry registry = Registry.getRegistry(null,null);
        InputStream stream = CommonAgent.class.getClassLoader().getResourceAsStream("mbeans-descriptors.xml");
        registry.loadMetadata(stream);
        MBeanServer server = registry.getMBeanServer();

        //different from "ManagementFactory.getPlatformMBeanServer();"
        ManagedBean managed = registry.findManagedBean("HelloModel");
        ObjectName helloName = new ObjectName(managed.getDomain() + ":name=Helloworld");

        ModelMBean hello =managed.createMBean(new HelloModel());
        server.registerMBean(hello, helloName);

        ObjectName adapterName = new ObjectName(managed.getDomain() + ":name=htmladaptor,port=8082");
        HtmlAdaptorServer adapter = new HtmlAdaptorServer();
        server.registerMBean(adapter, adapterName);
        adapter.start();
    }
}
