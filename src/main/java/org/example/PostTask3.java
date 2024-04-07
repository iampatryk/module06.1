package org.example;

import java.util.Objects;

public class PostTask3 {
        private long userID;
        private long id;
        private String title;
        private String body;

        public PostTask3() {}

    public PostTask3(long userID, long id, String title, String body) {
            this.userID = userID;
            this.id = id;
            this.title = title;
            this.body = body;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostTask3 postTask3 = (PostTask3) o;
        return userID == postTask3.userID && id == postTask3.id && Objects.equals(title, postTask3.title) && Objects.equals(body, postTask3.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, id, title, body);
    }

    @Override
    public String toString() {
        return "PostTask3{" +
                "userID=" + userID +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}

