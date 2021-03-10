package com.zxclown.learning.groovy;

import groovy.json.JsonOutput;
import groovy.sql.GroovyRowResult;
import groovy.sql.Sql;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

@Slf4j
public class JavaMainTest {
    @Test
    public void testGroovy() {
        Person person = new Person();
        person.setAge(13);
        person.setGender("男");
        person.setName("张三");
        assert "张三".equals(person.getName());
        log.info(JsonOutput.prettyPrint(JsonOutput.toJson(person)));
        try {
            Sql sql = Sql.newInstance("jdbc:mysql://localhost:3306/statemachine?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8", "root", "root", "com.mysql.cj.jdbc.Driver");
            List<GroovyRowResult> rows = sql.rows("select * from state_flow limit 10");
            rows.forEach(x -> log.info(JsonOutput.prettyPrint(JsonOutput.toJson(x))));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
