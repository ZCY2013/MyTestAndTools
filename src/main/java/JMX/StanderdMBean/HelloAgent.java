package JMX.StanderdMBean;

import javax.management.*;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import com.sun.jdmk.comm.HtmlAdaptorServer;

//remote connection url : service:jmx:rmi:///jndi/rmi://localhost:1099/HelloMBean

public class HelloAgent {
    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, IOException {

// 首先建立一个MBeanServer,MBeanServer用来管理我们的MBean,通常是通过MBeanServer来获取我们MBean的信息，间接
// 调用MBean的方法，然后生产我们的资源的一个对象。
            MBeanServer mbs = MBeanServerFactory.createMBeanServer();
            String domainName = "HelloMBean";
//为MBean（下面的new Hello()）创建ObjectName实例
            ObjectName helloName = new ObjectName(domainName+":name=HelloWorld");
// 将new Hello()这个对象注册到MBeanServer上去
        Hello hello = new Hello();
            mbs.registerMBean(hello, helloName);

// Distributed Layer, 提供了一个HtmlAdaptor。支持Http访问协议，并且有一个不错的HTML界面，这里的Hello就是用这个作为远端管理的界面
// 事实上HtmlAdaptor是一个简单的HttpServer，它将Http请求转换为JMX Agent的请求
            ObjectName adapterName = new ObjectName(domainName+":name=htmladapter,port=8082");
            HtmlAdaptorServer adapter = new HtmlAdaptorServer();
            mbs.registerMBean(adapter,adapterName);

            XXX xx = new XXX();
            mbs.registerMBean(xx, new ObjectName(domainName+":name=anonymous"));

            Client client = new Client();
            xx.addNotificationListener(new HelloListener(), null, null);
            adapter.start();
            int rmiPort = 1099;
            Registry registry = LocateRegistry.createRegistry(rmiPort);

            JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:"+rmiPort+"/"+domainName);
            JMXConnectorServer jmxConnector = JMXConnectorServerFactory.newJMXConnectorServer(url, null, mbs);
            jmxConnector.start();


    }
}
