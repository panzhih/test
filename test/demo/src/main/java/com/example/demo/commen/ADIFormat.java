package com.example.demo.commen;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Map;

@XmlRootElement(name = "ADIFormat")
public class ADIFormat {
    // 节点名称
    private String elementName;

    // 类型String,Long,Short,Integer,Enum,Date,Time
    private String type;

    // 默认值
    private String defaultValue;

    // 是否允许为空
    private boolean allowNull = true;

    // 枚举映射
    private Map<String, String> enumAlias;

    // 正则表达式^[a-zA-Z\\-]{4}[0-9]{16}$
    private String format;

    // 最小值
    private Double min;

    // 最大值
    private Double max;

    // 最大长度（用于String）
    private Double maxLength;

    // 错误信息
    private String errorMsg;

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getDefaultValue()
    {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue)
    {
        this.defaultValue = defaultValue;
    }

    public boolean getAllowNull()
    {
        return allowNull;
    }

    public void setAllowNull(boolean allowNull)
    {
        this.allowNull = allowNull;
    }

    public String getFormat()
    {
        return format;
    }

    public void setFormat(String format)
    {
        this.format = format;
    }

    public Map<String, String> getEnumAlias()
    {
        return enumAlias;
    }

    public void setEnumAlias(Map<String, String> enumAlias)
    {
        this.enumAlias = enumAlias;
    }

    public String getElementName()
    {
        return elementName;
    }

    public void setElementName(String elementName)
    {
        this.elementName = elementName;
    }

    public Double getMin()
    {
        return min;
    }

    public void setMin(Double min)
    {
        this.min = min;
    }

    public Double getMax()
    {
        return max;
    }

    public void setMax(Double max)
    {
        this.max = max;
    }

    public Double getMaxLength()
    {
        return maxLength;
    }

    public void setMaxLength(Double maxLength)
    {
        this.maxLength = maxLength;
    }

    public String getErrorMsg()
    {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg)
    {
        this.errorMsg = errorMsg;
    }
}
