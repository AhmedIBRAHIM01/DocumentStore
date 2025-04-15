package org.example;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Document implements Serializable {
    private int id;
    private String title;
    private Date creationDate;
    private List<String> authors;
    private String content;

    public Document(int id, String title, List<String> authors, String content) {
        this.id = id;
        this.title = title;
        this.creationDate = new Date();
        this.authors = authors;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public String getContent() {
        return content;
    }

    public String toString() {
        return "Document ID: " + id + "\nCreated: " + creationDate + "\nTitle: " + title +
                "\nAuthors: " + authors + "\nContent: " + content;
    }
}
