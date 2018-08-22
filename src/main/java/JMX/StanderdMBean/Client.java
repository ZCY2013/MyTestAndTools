package JMX.StanderdMBean;

import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.Set;

public class Client {
    public static void main(String[] args) throws IOException, MalformedObjectNameException, AttributeNotFoundException, MBeanException, ReflectionException, InstanceNotFoundException, InvalidAttributeValueException, IntrospectionException {
        String domainName = "HelloMBean";
        int rmiPort = 1099;
        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:"+rmiPort+"/"+domainName);
        JMXConnector jmxc = JMXConnectorFactory.connect(url);
        MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();
        System.out.println("DoMains:-------------");
        String domains[] = mbsc.getDomains();
        for (int i = 0; i < domains.length; i++) {
            System.out.println("\tDomain["+i+"] = " + domains[i]);
        }
        System.out.println("MBean count = " + mbsc.getMBeanCount());

        ObjectName mBeanName = new ObjectName(domainName + ":name=HelloWorld");
        mbsc.setAttribute(mBeanName, new Attribute("Name", "zzz"));
        System.out.println("Name = " + mbsc.getAttribute(mBeanName, "Name"));

        HelloMBean proxy = MBeanServerInvocationHandler.newProxyInstance(mbsc,  mBeanName, HelloMBean.class, false);
        proxy.printHello();
        proxy.printHello("jizhi boy");

        mbsc.invoke(mBeanName, "printHello", null, null);
        mbsc.invoke(mBeanName, "printHello", new String[]{"jizhi gril"}, new String[]{String.class.getName()});

        MBeanInfo info = mbsc.getMBeanInfo(mBeanName);
        System.out.println("Hello Class: "+info.getClassName());
        for(int i=0;i<info.getAttributes().length;i++){
            System.out.println("Hello Attribute:"+info.getAttributes()[i].getName());
        }
        for(int i=0;i<info.getOperations().length;i++){
            System.out.println("Hello Operation:"+info.getOperations()[i].getName());
        }

        //ObjectName of MBean
        System.out.println("all ObjectName:--------------");
        Set<ObjectInstance> set = mbsc.queryMBeans(null, null);
        for(Iterator<ObjectInstance> it = set.iterator(); it.hasNext();){
            ObjectInstance oi = it.next();
            System.out.println("\t"+oi.getObjectName());
        }
        jmxc.close();

    }
}

