package com.techelevator.projects.dao;

import com.techelevator.projects.model.Timesheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class JdbcTimesheetDaoTests extends BaseDaoTests {

    private static final Timesheet TIMESHEET_1 = new Timesheet(1, 1, 1,
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    private static final Timesheet TIMESHEET_2 = new Timesheet(2, 1, 1,
            LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    private static final Timesheet TIMESHEET_3 = new Timesheet(3, 2, 1,
            LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    private static final Timesheet TIMESHEET_4 = new Timesheet(4, 2, 2,
            LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");

    private JdbcTimesheetDao jdbcTimesheetDao;


    @Before
    public void setup() {
        jdbcTimesheetDao = new JdbcTimesheetDao(dataSource);
    }

    @Test
    public void getTimesheetById_with_valid_id_returns_correct_timesheet() {

        Timesheet timesheet = jdbcTimesheetDao.getTimesheetById(1);
        Assert.assertNotNull("getTimesheetById(1) returned null", timesheet);
        assertTimesheetsMatch("getTimesheetById(1) returned wrong or partial data", TIMESHEET_1, timesheet);

        timesheet = jdbcTimesheetDao.getTimesheetById(2);
        Assert.assertNotNull("getTimesheetById(2) returned null", timesheet);
        assertTimesheetsMatch("getTimesheetById(2) returned wrong or partial data", TIMESHEET_2, timesheet);

        timesheet = jdbcTimesheetDao.getTimesheetById(3);
        Assert.assertNotNull("getTimesheetById(3) returned null", timesheet);
        assertTimesheetsMatch("getTimesheetById(3) returned wrong or partial data", TIMESHEET_3, timesheet);

        timesheet = jdbcTimesheetDao.getTimesheetById(4);
        Assert.assertNotNull("getTimesheetById(4) returned null", timesheet);
        assertTimesheetsMatch("getTimesheetById(4) returned wrong or partial data", TIMESHEET_4, timesheet);

        timesheet = jdbcTimesheetDao.getTimesheetById(5);
        Assert.assertNull("getTimesheetById(5) does not exist and should be null", timesheet);

    }

    @Test
    public void getTimesheetById_with_invalid_id_returns_null_timesheet() {
        int invalidTimesheetId = 10;

        Timesheet actualTimesheet = jdbcTimesheetDao.getTimesheetById(invalidTimesheetId);

        assertNull("getTimesheetById did not return null for an invalid ID", actualTimesheet);
    }

    @Test
    public void getTimesheetsByEmployeeId_with_valid_employee_id_returns_list_of_timesheets_for_employee() {
        int validEmployeeId = TIMESHEET_1.getEmployeeId();
        List<Timesheet> expectedTimesheets = List.of(TIMESHEET_1, TIMESHEET_2);

        List<Timesheet> actualTimesheets = jdbcTimesheetDao.getTimesheetsByEmployeeId(validEmployeeId);

        assertEquals("getTimesheetsByEmployeeId returned wrong number of timesheets", expectedTimesheets.size(), actualTimesheets.size());

        for (int i = 0; i < expectedTimesheets.size(); i++){
            assertTimesheetsMatch("getTimeseheetsByEmployeeId returned wrong or partial data", expectedTimesheets.get(i), actualTimesheets.get(i));
        }
    }

    @Test
    public void getTimesheetsByProjectId_with_valid_id_returns_list_of_all_timesheets_for_project() {
        int validProjectId = 1;
        List<Timesheet> timesheets = jdbcTimesheetDao.getTimesheetsByProjectId(validProjectId);
        Assert.assertEquals("getTimesheetByProjectId() returned wrong number of timesheets", 4, timesheets.size());
    }

    @Test
    public void createTimesheet_creates_timesheet() {
        Timesheet newTimeshseet = new Timesheet(5, 1, 1, LocalDate.parse("2021-03-01"), 3.0, true, "New Timeshseet");
        Timesheet createdTimesheet = jdbcTimesheetDao.createTimesheet(newTimeshseet);

        assertNotNull("createTimesheet did not return a created timesheet", createdTimesheet);
        assertTimesheetsMatch("createTimesheet did not create the correct timesheet", newTimeshseet, createdTimesheet);

    }

    @Test
    public void updateTimesheet_updates_timesheet() {
        Timesheet existingTimesheet = TIMESHEET_1;

        existingTimesheet.setHoursWorked(5.0);

        Timesheet updatedTimesheet = jdbcTimesheetDao.updateTimesheet(existingTimesheet);

        assertNotNull("updateTimesheet did not return an updated timesheet", updatedTimesheet);
        assertTimesheetsMatch("updatedTimesheet did not update the correct timesheet", existingTimesheet, updatedTimesheet);
    }

    @Test
    public void deleteTimesheetById_deletes_timesheet() {
        int timesheetIdToDelete = TIMESHEET_1.getTimesheetId();

        int rowsAffected = jdbcTimesheetDao.deleteTimesheetById(timesheetIdToDelete);

        assertEquals("deleteTimesheetById did not delete the correct number of rows", 1, rowsAffected);
        assertNull("deleteTimesheetById did not delete the timesheet", jdbcTimesheetDao.getTimesheetById(timesheetIdToDelete));
    }

    @Test
    public void getBillableHours_returns_correct_total() {
        int validEmployeeId = TIMESHEET_1.getEmployeeId();
        int validProjectId = TIMESHEET_1.getProjectId();

        double billableHours = jdbcTimesheetDao.getBillableHours(validEmployeeId, validProjectId);

        assertEquals("getBillableHours returned wrong total billable hours", 2.5, billableHours, 0.001);
    }

    private void assertTimesheetsMatch(String message, Timesheet expected, Timesheet actual) {
        Assert.assertEquals(message, expected.getTimesheetId(), actual.getTimesheetId());
        Assert.assertEquals(message, expected.getEmployeeId(), actual.getEmployeeId());
        Assert.assertEquals(message, expected.getProjectId(), actual.getProjectId());
        Assert.assertEquals(message, expected.getDateWorked(), actual.getDateWorked());
        Assert.assertEquals(message, expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        Assert.assertEquals(message, expected.isBillable(), actual.isBillable());
        Assert.assertEquals(message, expected.getDescription(), actual.getDescription());
    }

}
