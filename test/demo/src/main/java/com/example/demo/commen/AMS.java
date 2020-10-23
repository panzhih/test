package com.example.demo.commen;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"description", "creationDate", "versionMajor", "versionMinor", "product", "verb", "provider", "providerID", "assetID", "assetClass", "assetName"}
)
@XmlRootElement(
        name = "AMS"
)
public class AMS {
    @XmlAttribute(
            name = "Provider",
            required = true
    )
    public String provider;
    @XmlAttribute(
            name = "Product",
            required = true
    )
    public String product;
    @XmlAttribute(
            name = "Asset_Name",
            required = true
    )
    public String assetName;
    @XmlAttribute(
            name = "Version_Major",
            required = true
    )
    public String versionMajor;
    @XmlAttribute(
            name = "Version_Minor",
            required = true
    )
    public String versionMinor;
    @XmlAttribute(
            name = "Description",
            required = true
    )
    public String description;
    @XmlAttribute(
            name = "Creation_Date",
            required = true
    )
    public String creationDate;
    @XmlAttribute(
            name = "Provider_ID",
            required = true
    )
    public String providerID;
    @XmlAttribute(
            name = "Asset_ID",
            required = true
    )
    public String assetID;
    @XmlAttribute(
            name = "Asset_Class",
            required = true
    )
    public String assetClass;
    @XmlAttribute(
            name = "Verb",
            required = true
    )
    public String verb;

    public AMS() {
    }

    public String getProvider() {
        return this.provider;
    }

    public void setProvider(String value) {
        this.provider = value;
    }

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String value) {
        this.product = value;
    }

    public String getAssetName() {
        return this.assetName;
    }

    public void setAssetName(String value) {
        this.assetName = value;
    }

    public String getVersionMajor() {
        return this.versionMajor;
    }

    public void setVersionMajor(String value) {
        this.versionMajor = value;
    }

    public String getVersionMinor() {
        return this.versionMinor;
    }

    public void setVersionMinor(String value) {
        this.versionMinor = value;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public String getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(String value) {
        this.creationDate = value;
    }

    public String getProviderID() {
        return this.providerID;
    }

    public void setProviderID(String value) {
        this.providerID = value;
    }

    public String getAssetID() {
        return this.assetID;
    }

    public void setAssetID(String value) {
        this.assetID = value;
    }

    public String getAssetClass() {
        return this.assetClass;
    }

    public void setAssetClass(String value) {
        this.assetClass = value;
    }

    public String getVerb() {
        return this.verb;
    }

    public void setVerb(String value) {
        this.verb = value;
    }
}
