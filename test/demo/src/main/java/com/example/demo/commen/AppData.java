package com.example.demo.commen;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"value", "name", "app"}
)
@XmlRootElement(
        name = "App_Data"
)
public class AppData {
    @XmlAttribute(
            name = "App",
            required = true
    )
    public String app;
    @XmlAttribute(
            name = "Name",
            required = true
    )
    public String name;
    @XmlAttribute(
            name = "Value",
            required = true
    )
    public String value;

    public AppData() {
    }

    public String getApp() {
        return this.app;
    }

    public void setApp(String value) {
        this.app = value;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
