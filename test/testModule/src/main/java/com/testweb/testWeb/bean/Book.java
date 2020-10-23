package com.testweb.testWeb.bean;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "test",type = "book")
public class Book {
    private String name;
    private String content;
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", id=" + id +
                '}';
    }
}
