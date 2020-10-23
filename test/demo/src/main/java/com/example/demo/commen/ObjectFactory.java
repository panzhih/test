/*
 * 文 件 名:  ObjectFactory.java
 * 版    权:  Shenzhen Coship Electronics Co.,Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  905232
 * 修改时间:  2013-1-13
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.example.demo.commen;


import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * <一句话功能简述> <功能详细描述>
 * @author 905232
 * @version [版本号, 2013-1-14]
 * @since [产品/模块版本]
 */
@XmlRegistry
public class ObjectFactory
{
    private final static QName _ADI_QNAME = new QName("ADI", "ADI");

    private final static QName _DHMFormat_QNAME = new QName("DHMFormat",
            "DHMFormat");

    public ObjectFactory()
    {
    }

    public ADI createADI()
    {
        return new ADI();
    }

    public DHMFormat createDHMFormat()
    {
        return new DHMFormat();
    }

    @XmlElementDecl(namespace = "ADI", name = "ADI")
    public JAXBElement<ADI> createADI(ADI value)
    {
        return new JAXBElement<ADI>(_ADI_QNAME, ADI.class, null, value);
    }

    @XmlElementDecl(namespace = "DHMFormat", name = "DHMFormat")
    public JAXBElement<DHMFormat> createDHMFormat(DHMFormat value)
    {
        return new JAXBElement<DHMFormat>(_DHMFormat_QNAME, DHMFormat.class,
                null, value);
    }
}
