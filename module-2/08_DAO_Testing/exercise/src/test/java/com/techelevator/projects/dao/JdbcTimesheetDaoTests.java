package com.techelevator.projects.dao;

import com.techelevator.projects.model.Timesheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcTimesheetDaoTests extends BaseDaoTests {

    private static final Timesheet TIMESHEET_1 = new Timesheet(1L, 1L, 1L, 
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    private static final Timesheet TIMESHEET_2 = new Timesheet(2L, 1L, 1L,
            LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    private static final Timesheet TIMESHEET_3 = new Timesheet(3L, 2L, 1L,
            LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    private static final Timesheet TIMESHEET_4 = new Timesheet(4L, 2L, 2L,
            LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");
    
    private JdbcTimesheetDao sut;


    @Before
    public void setup() {
        sut = new JdbcTimesheetDao(dataSource);
    }

    @Test
    public void getTimesheet_returns_correct_timesheet_for_id() {
        Timesheet expectedTimesheet = TIMESHEET_1;
        Timesheet actualTimesheet = sut.getTimesheet(1L);
        assertTimesheetsMatch(expectedTimesheet, actualTimesheet);
    }

    @Test
    public void getTimesheet_returns_null_when_id_not_found() {
        Timesheet retrievedTimesheet = sut.getTimesheet(5L);
        Assert.assertNull(retrievedTimesheet);
    }

    @Test
    public void getTimesheetsByEmployeeId_returns_list_of_all_timesheets_for_employee() {
        int expectedSize = 2;
        List<Timesheet> actualTimesheets = sut.getTimesheetsByEmployeeId(1L);

        Assert.assertEquals(expectedSize, actualTimesheets.size());
    }

    @Test
    public void getTimesheetsByProjectId_returns_list_of_all_timesheets_for_project() {
        int expectedSize = 3;
        List<Timesheet> actualTimesheets = sut.getTimesheetsByProjectId(1L);

        Assert.assertEquals(expectedSize, actualTimesheets.size());
    }

    @Test
    public void createTimesheet_returns_timesheet_with_id_and_expected_values() {
        Timesheet expectedTimesheet = new Timesheet(1L, 1L, 1L, LocalDate.now(), 3.0, false, "Timesheet 5");
        Timesheet actualTimesheet = sut.createTimesheet(expectedTimesheet);

        expectedTimesheet.setTimesheetId(actualTimesheet.getTimesheetId());
        expectedTimesheet.setEmployeeId(actualTimesheet.getEmployeeId());
        expectedTimesheet.setProjectId(actualTimesheet.getProjectId());

        this.assertTimesheetsMatch(expectedTimesheet, actualTimesheet);
    }

    @Test
    public void created_timesheet_has_expected_values_when_retrieved() {
        Timesheet expectedTimesheet = new Timesheet(1L, 1L, 1L, LocalDate.now(), 3.0, false, "Timesheet 5");
        Timesheet createdTimesheet = sut.createTimesheet(expectedTimesheet);

        expectedTimesheet.setTimesheetId(createdTimesheet.getTimesheetId());
        expectedTimesheet.setEmployeeId(createdTimesheet.getEmployeeId());
        expectedTimesheet.setProjectId(createdTimesheet.getProjectId());

        Timesheet actualTimesheet = sut.getTimesheet(createdTimesheet.getTimesheetId());

        this.assertTimesheetsMatch(expectedTimesheet, actualTimesheet);
    }

    @Test
    public void updated_timesheet_has_expected_values_when_retrieved() {
        Timesheet updatedTimesheet = sut.getTimesheet(1L);
        updatedTimesheet.setDateWorked(LocalDate.now());
        updatedTimesheet.setHoursWorked(1.5);
        updatedTimesheet.setBillable(false);
        updatedTimesheet.setDescription("Jay's Timesheet");

        sut.updateTimesheet(updatedTimesheet);

        Timesheet retrievedTimesheet = sut.getTimesheet(1L);

        this.assertTimesheetsMatch(updatedTimesheet, retrievedTimesheet);
    }

    @Test
    public void deleted_timesheet_cant_be_retrieved() {
        sut.deleteTimesheet(4L);
        Timesheet retrievedTimesheet = sut.getTimesheet(4L);
        Assert.assertNull(retrievedTimesheet);
    }

    @Test
    public void getBillableHours_returns_correct_total() {
        double expectedSum = 2.5;
        double actualSum = sut.getBillableHours(1L, 1L);

        Assert.assertEquals(expectedSum, actualSum, 0.0);

        double expectedSumForNonBillable = 0.0;
        double actualSumNonBillable = sut.getBillableHours(2L, 2L);

        Assert.assertEquals(expectedSumForNonBillable, actualSumNonBillable, 0.0);
    }

    private void assertTimesheetsMatch(Timesheet expected, Timesheet actual) {
        Assert.assertEquals(expected.getTimesheetId(), actual.getTimesheetId());
        Assert.assertEquals(expected.getEmployeeId(), actual.getEmployeeId());
        Assert.assertEquals(expected.getProjectId(), actual.getProjectId());
        Assert.assertEquals(expected.getDateWorked(), actual.getDateWorked());
        Assert.assertEquals(expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        Assert.assertEquals(expected.isBillable(), actual.isBillable());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
    }

}
