package com.example.demo.commen;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Map;

@XmlRootElement(name = "DHMFormat")
public class DHMFormat {

    private Map<String, ADIFormat> adiFormats;

    public Map<String, ADIFormat> getAdiFormats()
    {
        return adiFormats;
    }

    public void setAdiFormats(Map<String, ADIFormat> adiFormats)
    {
        this.adiFormats = adiFormats;
    }
}
