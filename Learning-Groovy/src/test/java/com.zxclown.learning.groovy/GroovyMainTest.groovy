package com.zxclown.learning.groovy

import groovy.json.JsonOutput
import groovy.sql.Sql
import org.junit.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import java.sql.ResultSet

class GroovyMainTest {
    public static final Logger logger = LoggerFactory.getLogger(GroovyMainTest.class)

    @Test
    void testPerson() {
//        Person person = new Person()
//        person.name = "张三"
//        person.age = 31
//        person.gender = "男"
//        assert person.name == "张三"
//        logger.info(JsonOutput.prettyPrint(JsonOutput.toJson(person)))
        Sql sql = Sql.newInstance("jdbc:mysql://localhost:3306/statemachine?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8", "root", "root", "com.mysql.cj.jdbc.Driver");
        ResultSet columns = sql.connection.getMetaData().getColumns(null, "%", "state_flow", "%")
        while (columns.next()) {
            String columnName = columns.getString("COLUMN_NAME");
            String columnType = columns.getString("TYPE_NAME");
            int datasize = columns.getInt("COLUMN_SIZE");
            logger.info("=== columnName: {}, typeName: {}, dataSize: {} ====", columnName, columnType, datasize)
        }
        sql.rows("select * from state_flow limit 10").forEach { x -> logger.info(JsonOutput.prettyPrint(JsonOutput.toJson(x))) }
    }
}
