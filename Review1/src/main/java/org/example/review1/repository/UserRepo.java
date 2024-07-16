package org.example.review1.repository;

import org.example.review1.module.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepo {

    @Autowired
    private JdbcTemplate template;


    public void save(User user){
        String query = "insert into Users (id, uname, usurname) values (?, ?, ?)";
        System.out.println("added");
        user.setUid(getAll().size()+1);
        template.update(query, user.getUid(), user.getuName(), user.getuSurname());

    }

    public List<User> getAll(){
        String query = "select * from Users";

        RowMapper<User> mapper = (rs, rowNum) -> {
            User user = new User();
            user.setuName(rs.getString(2));
            user.setuSurname(rs.getString(3));

            return user;
        };

        return template.query(query, mapper);

    }

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
}
