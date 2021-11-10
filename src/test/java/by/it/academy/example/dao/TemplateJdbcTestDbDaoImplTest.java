package by.it.academy.example.dao;

import by.it.academy.example.entity.CommandsSQL;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TemplateJdbcTestDbDaoImplTest {
    private TemplateJdbcTestDbDAO templateJdbcTestDbDao;
    private TemplateJdbcTestDbDaoImpl templateJdbcTestDbDaoImpl;
    private CommandsSQL sql;

    @BeforeEach
    void createCommandsSqlAndJdbcTestDbDaoImpl(){
        templateJdbcTestDbDaoImpl = mock(TemplateJdbcTestDbDaoImpl.class);
        assertDoesNotThrow(()->{templateJdbcTestDbDaoImpl.initTemplate();});
        templateJdbcTestDbDao = mock(TemplateJdbcTestDbDaoImpl.class);
        sql = mock(CommandsSQL.class);
    }

    @Test
    void testSaveDAO(){
        sql.setInsert("x","x");
        Assertions.assertAll("Error",
                () -> Assertions.assertEquals(0, templateJdbcTestDbDao.delete(sql)),
                () -> Assertions.assertThrows(SQLException.class,()->{
                    when(templateJdbcTestDbDao.save(sql)).thenThrow(new SQLException("Mock exception does not work"));
                    templateJdbcTestDbDao.save(sql);})
        );
    }

    @Test
    void testGetDAO(){
        sql.setSelect("x","x");
        Assertions.assertAll("Error",
                () -> Assertions.assertEquals(0, templateJdbcTestDbDao.get(sql)),
                () -> Assertions.assertThrows(SQLException.class,()->{
                    when(templateJdbcTestDbDao.get(sql)).thenThrow(new SQLException("Mock exception does not work"));
                    templateJdbcTestDbDao.get(sql);})
        );
    }

    @Test
    void testUpdateDAO(){
        sql.setUpdate("x","x");
        Assertions.assertAll("Error",
                () -> Assertions.assertEquals(0, templateJdbcTestDbDao.update(sql)),
                () -> Assertions.assertThrows(SQLException.class,()->{
                    when(templateJdbcTestDbDao.update(sql)).thenThrow(new SQLException("Mock exception does not work"));
                    templateJdbcTestDbDao.update(sql);})
        );
    }

    @Test
    void testDeleteDAO(){
        sql.setDelete("x","x");
        Assertions.assertAll("Error",
                () -> Assertions.assertEquals(0, templateJdbcTestDbDao.delete(sql)),
                () -> Assertions.assertThrows(SQLException.class,()->{
                when(templateJdbcTestDbDao.delete(sql)).thenThrow(new SQLException("Mock exception does not work"));
                    templateJdbcTestDbDao.delete(sql);})
        );


    }

    @Test
    void testGetSelectDAO(){
        Assertions.assertAll("Error",
                () -> Assertions.assertEquals(
                        0, templateJdbcTestDbDao.getSelect(sql,"x","x",1)),
                () -> Assertions.assertThrows(SQLException.class,()->{
                    when(templateJdbcTestDbDao.getSelect(sql,"x","x",1))
                            .thenThrow(new SQLException("Mock exception does not work"));
                    templateJdbcTestDbDao.getSelect(sql,"x","x",1);})
        );
    }
}
