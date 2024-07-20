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
            user.setUid(rs.getInt(1));
            user.setuName(rs.getString(2));
            user.setuSurname(rs.getString(3));

            return user;
        };

        return template.query(query, mapper);

    }

    public User getById(int id){
        String query = "select * from Users where id=" + id;
        User user = new User();

        RowMapper<User> mapper = (rs, rowNum) -> {

            user.setUid(rs.getInt(1));
            user.setuName(rs.getString(2));
            user.setuSurname(rs.getString(3));

            return user;
        };

        return template.queryForObject(query, mapper);
    }

    public User getByName(String name){
        String query = "select * from Users where uname='"+name+"'";
        User user = new User();

        RowMapper<User> mapper = (rs, rowNum) -> {

            user.setUid(rs.getInt(1));
            user.setuName(rs.getString(2));
            user.setuSurname(rs.getString(3));

            return user;
        };

        template.query(query, mapper);

        return user;
    }

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
}
