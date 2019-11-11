package connectionPoll;

import connectionPoll.domain.Employee;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class HikariCPDemoTest {
    @Test
    public void givenConnection_thenFetchDbData() throws SQLException {
        List<Employee> employees = HikariCPDemo.fetchData();

        assertEquals( 4, employees.size() );
    }
}