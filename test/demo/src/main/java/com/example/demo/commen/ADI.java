package com.example.demo.commen;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"metadata", "asset"}
)
@XmlRootElement(
        name = "ADI"
)
public class ADI {
    @XmlElement(
            name = "Metadata",
            required = true
    )
    public Metadata metadata;
    @XmlElement(
            name = "Asset",
            required = true
    )
    public List<Asset> asset;

    public ADI() {
    }

    public Metadata getMetadata() {
        return this.metadata;
    }

    public void setMetadata(Metadata value) {
        this.metadata = value;
    }

    public List<Asset> getAsset() {
        return this.asset;
    }

    public void setAsset(List<Asset> value) {
        this.asset = value;
    }
}