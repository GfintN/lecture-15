package by.it.academy.example.dao;

import by.it.academy.example.entity.CommandsSQL;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JdbcTestDbDaoImplTest {
    private JdbcTestDbDaoImpl jdbcTestDbDaoImpl;
    private JdbcTestDbDAO jdbcTestDbDao;
    private CommandsSQL sql;

    @BeforeEach
    void createCommandsSqlAndJdbcTestDbDaoImpl(){
        jdbcTestDbDaoImpl = mock(JdbcTestDbDaoImpl.class);
        jdbcTestDbDao = mock(JdbcTestDbDaoImpl.class);
        sql = mock(CommandsSQL.class);
        Assertions.assertDoesNotThrow(()->{jdbcTestDbDaoImpl.openConnection();});
        jdbcTestDbDaoImpl.closeConnection();
    }

    @Test
    void testSaveDAO(){
        sql.setInsert("x","x");
        Assertions.assertAll("Error",
                () -> Assertions.assertEquals(0, jdbcTestDbDao.save(sql)),
                () -> Assertions.assertThrows(SQLException.class,()->{
                    when(jdbcTestDbDao.save(sql)).thenThrow(new SQLException("Mock exception does not work"));
                    jdbcTestDbDao.save(sql);})
        );
    }

    @Test
    void testGetDAO(){
        sql.setSelect("x","x");
        Assertions.assertAll("Error",
                () -> Assertions.assertEquals(0, jdbcTestDbDao.get(sql)),
                () -> Assertions.assertThrows(SQLException.class,()->{
                    when(jdbcTestDbDao.get(sql)).thenThrow(new SQLException("Mock exception does not work"));
                    jdbcTestDbDao.get(sql);})
        );
    }

    @Test
    void testUpdateDAO(){
        sql.setUpdate("x","x");
        Assertions.assertAll("Error",
                () -> Assertions.assertEquals(0, jdbcTestDbDao.update(sql)),
                () -> Assertions.assertThrows(SQLException.class,()->{
                    when(jdbcTestDbDao.update(sql)).thenThrow(new SQLException("Mock exception does not work"));
                    jdbcTestDbDao.update(sql);})
        );
    }

    @Test
    void testDeleteDAO(){
        sql.setDelete("x","x");
        Assertions.assertAll("Error",
                () -> Assertions.assertEquals(0, jdbcTestDbDao.delete(sql)),
                () -> Assertions.assertThrows(SQLException.class,()->{
                    when(jdbcTestDbDao.delete(sql)).thenThrow(new SQLException("Mock exception does not work"));
                    jdbcTestDbDao.delete(sql);})
        );
    }

    @AfterEach
    void closeConnection(){
        jdbcTestDbDaoImpl.closeConnection();
    }

}
