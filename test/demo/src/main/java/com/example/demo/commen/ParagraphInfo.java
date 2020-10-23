package com.example.demo.commen;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlType(
        name = "ParagraphInfo",
        propOrder = {"paragraphID", "startTime", "endTime", "title", "description", "tag", "type", "userReviews", "appData"}
)
@XmlRootElement(
        name = "ParagraphInfo"
)
@XmlAccessorType(XmlAccessType.FIELD)
public class ParagraphInfo {
    @XmlAttribute(
            name = "paragraphID",
            required = true
    )
    public String paragraphID;
    @XmlAttribute(
            name = "startTime",
            required = true
    )
    public String startTime;
    @XmlAttribute(
            name = "endTime",
            required = true
    )
    public String endTime;
    @XmlAttribute(
            name = "title",
            required = true
    )
    public String title;
    @XmlAttribute(
            name = "description"
    )
    public String description;
    @XmlAttribute(
            name = "tag"
    )
    public String tag;
    @XmlAttribute(
            name = "type"
    )
    public String type;
    @XmlAttribute(
            name = "userReviews"
    )
    public String userReviews;
    @XmlElement(
            name = "App_Data"
    )
    public List<AppData> appData;

    public ParagraphInfo() {
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserReviews() {
        return this.userReviews;
    }

    public void setUserReviews(String userReviews) {
        this.userReviews = userReviews;
    }

    public String getParagraphID() {
        return this.paragraphID;
    }

    public void setParagraphID(String paragraphID) {
        this.paragraphID = paragraphID;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<AppData> getAppData() {
        return this.appData;
    }

    public void setAppData(List<AppData> appData) {
        this.appData = appData;
    }
}
