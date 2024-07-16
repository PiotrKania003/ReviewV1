package org.example.review1.module;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class User {
    int uid;
    String uName;
    String uSurname;

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuSurname() {
        return uSurname;
    }

    public void setuSurname(String uSurname) {
        this.uSurname = uSurname;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uName='" + uName + '\'' +
                ", uSurname='" + uSurname + '\'' +
                '}';
    }
}
