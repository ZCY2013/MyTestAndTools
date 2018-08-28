package JMX.ModelMBean;

import JMX.StanderdMBean.Hello;

import javax.management.Descriptor;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanParameterInfo;
import javax.management.modelmbean.*;

public class ModelMBeanUtils {
    private static final boolean READABLE = true;
    private static final boolean WRITABLE = true;
    private static final boolean BOOLEAN = true;
    private static final String STRING_CLASS = "java.lang.String";

    public static RequiredModelMBean createModelerMBean() {
        RequiredModelMBean model = null;
        try {
            model = new RequiredModelMBean();
            model.setManagedResource(new Hello(), "ObjectReference");
            ModelMBeanInfo mInfo = createModelMBeanInfo();
            model.setModelMBeanInfo(mInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    private static ModelMBeanInfo createModelMBeanInfo() {
        //attribute
        Descriptor portAttrDesc = new DescriptorSupport();
        portAttrDesc.setField("name","Name");
        portAttrDesc.setField("descriptorType", "attribute");
        portAttrDesc.setField("displayName", "Name");
        portAttrDesc.setField("getMethod", "getName"); //"getName22" will cause ServiceNotFoundException
        portAttrDesc.setField("setMethod", "setName"); //this match the object's method & attribute
        ModelMBeanAttributeInfo nameAttrInfo = new ModelMBeanAttributeInfo(
                "Name",
                STRING_CLASS,
                "people name",
                READABLE, WRITABLE, !BOOLEAN,
                portAttrDesc
        );

        // method
        Descriptor getStateDesc = new DescriptorSupport(new String[] {
                "name=getName",
                "descriptorType=operation",
                "class=JMX.StanderdMBean.Hello",
                "role=operation"
        });

        ModelMBeanOperationInfo getName = new ModelMBeanOperationInfo(//
                "getName", //
                "get name attribute", //
                null, //
                "java.lang.String", //
                MBeanOperationInfo.ACTION,
                getStateDesc //if null  there is a default value ,but error will caused exception
        );
        //construct description info
        Descriptor setStateDesc = new DescriptorSupport(new String[] {
                "name=setName", "descriptorType=operation", "class=JMX.StanderdMBean.Hello",
                "role=operation" });

        MBeanParameterInfo[] setStateParms = new MBeanParameterInfo[] { (new MBeanParameterInfo(
                "name", "java.lang.String", "new name value")) };

        ModelMBeanOperationInfo setName = new ModelMBeanOperationInfo(//
                "setName", //
                "set name attribute", //
                setStateParms, //
                "void", //
                MBeanOperationInfo.ACTION, //
               setStateDesc
        );
        //construct hello infomation
        ModelMBeanOperationInfo print1Info = new ModelMBeanOperationInfo(//
                "printHello", //
                null, //
                null, //
                "void", //
                MBeanOperationInfo.INFO, //
                null //
        );
        //construct printhello infomation
        ModelMBeanOperationInfo print2Info;
        MBeanParameterInfo[] param2 = new MBeanParameterInfo[1];
        param2[0] = new MBeanParameterInfo("whoName", STRING_CLASS, "say hello to who");
        print2Info = new ModelMBeanOperationInfo(//
                "printHello", //
                null,//
                param2,//
                "void", //
                MBeanOperationInfo.INFO, //
                null//
        );
        //submit
        ModelMBeanInfo mbeanInfo = new ModelMBeanInfoSupport(//
                RequiredModelMBean.class.getName(), // MBean类
                "mbeanINfo description", // 描述文字
                new ModelMBeanAttributeInfo[] { // 所有的属性信息（数组）
                        nameAttrInfo },//只有一个属性
                null, // 所有的构造函数信息
                new ModelMBeanOperationInfo[] { // 所有的操作信息（数组）
                        getName,
                        setName,
                        print1Info,
                        print2Info },//
                null, // 所有的通知信息(本例无)
                null//MBean描述
        );
        return mbeanInfo;

    }
}