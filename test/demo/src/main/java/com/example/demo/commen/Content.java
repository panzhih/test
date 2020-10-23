package com.example.demo.commen;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = ""
)
@XmlRootElement(
        name = "Content"
)
public class Content {
    @XmlAttribute(
            name = "Value",
            required = true
    )
    public String value;

    public Content() {
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
