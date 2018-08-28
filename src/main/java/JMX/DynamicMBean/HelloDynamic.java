package JMX.DynamicMBean;

import javax.management.*;
import java.lang.reflect.Constructor;
import java.util.Iterator;

public class HelloDynamic implements DynamicMBean {

    private String name;
    private MBeanInfo mBeanInfo = null;
    private String className;
    private String description;
    private MBeanAttributeInfo[] attributes;
    private MBeanConstructorInfo[] constructors;
    private MBeanOperationInfo[] operations;
    private MBeanNotificationInfo[] mBeanNotificationInfoArray;

    private void init(){
        className = this.getClass().getName();
        description = "Simple implementation of a dynamic MBean.";
        attributes = new MBeanAttributeInfo[1];
        constructors = new MBeanConstructorInfo[1];
        operations = new MBeanOperationInfo[1];
        mBeanNotificationInfoArray = new MBeanNotificationInfo[0];
    }
    private void buildDynamicMBean(){
        Constructor[] thisConstructors = this.getClass().getConstructors();
        constructors[0] = new MBeanConstructorInfo("HelloDynamic(): Constructs a HelloDynamic Object",thisConstructors[0]);
        attributes[0] = new MBeanAttributeInfo("name","java.lang.String","Name:name string.",true,true,false);
        operations[0] = new MBeanOperationInfo("print","print():print the name",null,"void",MBeanOperationInfo.INFO);
        mBeanInfo = new MBeanInfo(className,description,attributes,constructors,operations,mBeanNotificationInfoArray);
    }

    public HelloDynamic(){
        init();
        buildDynamicMBean();
    }

    private void dynamicAddOperation(){
        init();
        operations = new MBeanOperationInfo[3];
        buildDynamicMBean();
        operations[1] = new MBeanOperationInfo("print1","print1():print the name",null,"void",MBeanOperationInfo.INFO);
        //add a method
        MBeanParameterInfo[] params = new MBeanParameterInfo[] { (new MBeanParameterInfo(
                "name", "java.lang.String", "new name value")) };
        operations[2] = new MBeanOperationInfo("setName", "getName():get the name", params, "java.lang.String", MBeanOperationInfo.INFO);
        mBeanInfo = new MBeanInfo(className,description,attributes,constructors,operations,mBeanNotificationInfoArray);
    }

    @Override
    public Object getAttribute(String attribute)  {
        if (attribute == null) {
            return null;
        }
        if (attribute.equals("Name")) {
            return name;
        }

        return null;
    }

    @Override
    public void setAttribute(Attribute attribute) {
        if (attribute == null) {
            return;
        }

        String Name = attribute.getName();
        Object value = attribute.getValue();

        try {
            if (Name.equals("Name")) {
                if (value == null) {
                    name=null;
                } else if (Class.forName("java.lang.String").isAssignableFrom(value.getClass())) {
                    name =  (String)value;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public AttributeList getAttributes(String[] attributes) {
        if (attributes == null) {
            return null;
        }
        AttributeList resultList = new AttributeList();
//        if (attributes.length == 0) {
//            return resultList;
//        }
        for(int i=0;i<attributes.length;i++){
            Object value = getAttribute(attributes[i]);
            resultList.add(new Attribute(attributes[i],value));
        }

        return resultList;
    }

    @Override
    public AttributeList setAttributes(AttributeList attributes) {
        if (attributes == null) {
            return null;
        }
        AttributeList resultList = new AttributeList();
        if(attributes.isEmpty()){
            return resultList;
        }
        for(Iterator i = attributes.iterator(); i.hasNext();){
            Attribute attr = (Attribute) i.next();
            setAttribute(attr);
            String name = attr.getName();
            Object value = getAttribute(name);
            resultList.add(new Attribute(name,value));

        }

        return resultList;
    }

    @Override
    public Object invoke(String actionName, Object[] params, String[] signature) throws ReflectionException {
        if(actionName.equals("print")){
            System.out.println("Hello, "+name+",this is HelloDynamic!");
            dynamicAddOperation();
            return null;
        }
        else if(actionName.equals("print1")) {
            System.out.println("这是动态增加的一个方法print1");
            return null;
        }else if(actionName.equals("setName")){
            this.name = (String)params[0];
            return null;
        }
        else {
            throw new ReflectionException(new NoSuchMethodException(actionName),"Cannot find the operation "+actionName+" in "+className);
        }
    }

    @Override
    public MBeanInfo getMBeanInfo() {
        return mBeanInfo;
    }

}
