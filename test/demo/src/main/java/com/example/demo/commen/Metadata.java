package com.example.demo.commen;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"ams", "appData", "paragraphList"}
)
@XmlRootElement(
        name = "Metadata"
)
public class Metadata {
    @XmlElement(
            name = "AMS",
            required = true
    )
    public AMS ams;
    @XmlElement(
            name = "App_Data",
            required = true
    )
    public List<AppData> appData;
    @XmlElement(
            name = "ParagraphInfo"
    )
    @XmlElementWrapper(
            name = "ParagraphList"
    )
    public List<ParagraphInfo> paragraphList;

    public Metadata() {
    }

    public List<ParagraphInfo> getParagraphList() {
        return this.paragraphList;
    }

    public void setParagraphList(List<ParagraphInfo> paragraphList) {
        this.paragraphList = paragraphList;
    }

    public AMS getAMS() {
        return this.ams;
    }

    public void setAMS(AMS value) {
        this.ams = value;
    }

    public List<AppData> getAppData() {
        if (this.appData == null) {
            this.appData = new ArrayList();
        }

        return this.appData;
    }

    public void setAppData(List<AppData> value) {
        this.appData = value;
    }
}
