package com.example.demo.commen;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"metadata", "asset", "content"}
)
@XmlRootElement(
        name = "Asset"
)
public class Asset {
    @XmlElement(
            name = "Metadata",
            required = true
    )
    public Metadata metadata;
    @XmlElement(
            name = "Asset"
    )
    public List<Asset> asset;
    @XmlElement(
            name = "Content"
    )
    public Content content;

    public Asset() {
    }

    public Metadata getMetadata() {
        return this.metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public List<Asset> getAsset() {
        return this.asset;
    }

    public void setAsset(List<Asset> asset) {
        this.asset = asset;
    }

    public Content getContent() {
        return this.content;
    }

    public void setContent(Content content) {
        this.content = content;
    }
}
