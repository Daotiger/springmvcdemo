package com.syau.hello.dao.impl;

import com.syau.hello.dao.StudentDao;
import com.syau.hello.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Boolean add(Student stu) {

        String sql = "INSERT INTO student (number, `name`, age) VALUEs(?,?,?)";

        jdbcTemplate.update(sql, stu.getNumber(), stu.getName(), stu.getAge());

        return true;
    }

    @Override
    public Boolean delete(Integer number) {

        String sql = "DELETE FROM student WHERE number = ?";

        jdbcTemplate.update(sql, number);
        return true;
    }

    @Override
    public Boolean update(Student stu) {

        if (stu == null) {
            return false;
        }
        //临时定义
        //更新除id以外所有内容

        //动态拼接更新sql
        //String sql = "DELETE FROM student WHERE number= ?";
        //UPDATE student SET number = ?, name=?, age=? WHERE id = 1
        StringBuilder sqlSB = new StringBuilder("UPDATE student SET");

        if (stu.getNumber() != null && !stu.getNumber().equals(0)) {
            sqlSB.append(" number = ?,");
        }
        if (stu.getAge() != null && !stu.getAge().equals(0)) {
            sqlSB.append(" age = ?,");
        }
        if (stu.getName() != null && !stu.getNumber().equals("")) {
            sqlSB.append(" name = ?");
        }

        //条件
        sqlSB.append(" id = ?");

        jdbcTemplate.update(sqlSB.toString(), stu.getNumber(), stu.getAge(), stu.getName(), stu.getId());
        return true;
    }

    @Override
    public Student select(Integer number) {

        String sql = "SELECT id, number , `name` , age FROM student where number = ?";

//        jdbcTemplate.queryForObject(sql,Student.class);

        Student student = jdbcTemplate.queryForObject(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student condition = new Student();
                condition.setId(rs.getInt("id"));
                condition.setNumber(rs.getInt("number"));
                condition.setName(rs.getString("name"));
                condition.setAge(rs.getInt("age"));
                return condition;
            }
        }, number);

        return student;
    }

    @Override
    public List<Student> selectAll() {

        String sql = "SELECT\n" +
                "\tstudent.id,\n" +
                "\tstudent.number,\n" +
                "\tstudent.`name`,\n" +
                "\tstudent.age\n" +
                "FROM\n" +
                "\tstudent";

        List<Student> studentList = jdbcTemplate.query(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int i) throws SQLException {

                //这里必须new对象，不能在方法外new，然后用同一个，因为是一个List，查询出来多个对象映射，
                //必须保证每一次调用都使用一个新的。
                //如果不new，而是使用同一个对象，会导致存入到List中的都是一样的对象（都是最后一个对象）。
                Student condition = new Student();
                condition.setId(rs.getInt("id"));
                condition.setNumber(rs.getInt("number"));
                condition.setName(rs.getString("name"));
                condition.setAge(rs.getInt("age"));
                return condition;
            }
        });
        return studentList;
    }
}
