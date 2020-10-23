package com.example.demo.jaxbUtil;

import com.example.demo.commen.ADI;
import com.example.demo.commen.DHMFormat;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * <JAXB工具类> <功能详细描述>
 * @author 905232
 * @version [版本号, 2013-1-14]
 * @since [产品/模块版本]
 */
public class JAXBUtil {

    /** contextPath **/
    private final static String CONTEXT_PATH = "com.example.demo.commen";

    /**
     * <将File文件转换为ADI对象> <功能详细描述>
     * @param file
     * @return
     * @throws JAXBException [参数说明]
     * @return ADI [返回类型说明]
     * @throws //AMSException
     * @exception throws [违例类型] [违例说明]
     */
    public static ADI unmarshal(File file) throws JAXBException
    {
        if (null != file)
        {
            JAXBContext jc = JAXBContext.newInstance(CONTEXT_PATH);
            Unmarshaller unmarshaller = jc.createUnmarshaller();

            //  ，捕获file文件内容格式错误
            try
            {
                return (ADI) unmarshaller.unmarshal(file);
            }
            catch (JAXBException e)
            {
                System.out.println("adI转换失败");
            }
        }

        return null;
    }

    /**
     * <将File文件转换为DHMFormat对象> <功能详细描述>
     * @param file
     * @return
     * @throws JAXBException [参数说明]
     * @return ADI [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     */
    public static DHMFormat unmarshalDHMFormat(File file) throws JAXBException
    {
        if (null != file)
        {
            JAXBContext jc = JAXBContext.newInstance(CONTEXT_PATH);
            return (DHMFormat) jc.createUnmarshaller().unmarshal(file);
        }

        return null;
    }
}
