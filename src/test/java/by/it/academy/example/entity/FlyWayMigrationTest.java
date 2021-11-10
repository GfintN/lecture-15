package by.it.academy.example.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

import static org.mockito.Mockito.mock;

public class FlyWayMigrationTest {
    private FlyWayMigration flyway;
    private static FlyWayMigration flywayPostgresqlContainer;
    private static  DockerImageName myImage;
    private static PostgreSQLContainer postgreSQLContainer;

    @BeforeAll
    static void generateContainer(){
          myImage = DockerImageName.parse("gfintn/my-postgres:version.1").asCompatibleSubstituteFor("postgres");
          postgreSQLContainer = new PostgreSQLContainer(myImage);
          postgreSQLContainer.addExposedPort(5432);
          postgreSQLContainer.start();
          flywayPostgresqlContainer = mock(FlyWayMigration.class);
    }

    @BeforeEach
    void createFlyway(){
        flyway = mock(FlyWayMigration.class);
    }

    @Test
    void testSkipAutomaticAndTriggerManualFlywayMigration(){
        Assertions.assertDoesNotThrow(()-> {
            flyway.skipAutomaticAndTriggerManualFlywayMigration();
        });
    }

    @Test
    void testInitSqlAndMigrationFlyway(){
        Assertions.assertDoesNotThrow(()-> {
                flyway.initSqlAndMigrationFlyway("SELECT * FROM jdbc_test;");
            });
    }

    @Test
    void testFlywayOnDAO(){
        FlyWayMigrationTest.flywayPostgresqlContainer.initSqlAndMigrationFlyway("SELECT * FROM jdbc_test;");
    }
}


