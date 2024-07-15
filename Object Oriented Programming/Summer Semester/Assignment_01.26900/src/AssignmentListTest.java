import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class AssignmentListTest {
    @Test
    public void TestgetItemList() {
        Assignment assignment1 = new Assignment("Assignment1", 12, 9, 23, 00);
        Assignment assignment2 = new Assignment("Assignment2", 11, 4, 15, 30);
        assignment1.setTotalWeight(1.2);
        assignment1.setScore(18.0);
        assignment1.setTotalPoints(40.0);
        assignment2.setTotalWeight(1.5);
        assignment2.setScore(12.0);
        assignment2.setTotalPoints(34.0);
        AssignmentList assignment = new AssignmentList();
        assignment.addItem(assignment1);
        assignment.addItem(assignment2);
        ArrayList item = new ArrayList<>();
        item.add(assignment1);
        item.add(assignment2);
        Assert.assertTrue("Get items of the Assignment List", item.equals(assignment.getItemList()));
    }

    @Test
    public void testAddItem() {
        Assignment assignment1 = new Assignment("Assignment1", 12, 9, 23, 00);
        Assignment assignment2 = new Assignment("Assignment2", 11, 4, 15, 30);
        assignment1.setTotalWeight(1.2);
        assignment1.setScore(18.0);
        assignment1.setTotalPoints(40.0);
        assignment2.setTotalWeight(1.5);
        assignment2.setScore(12.0);
        assignment2.setTotalPoints(34.0);
        AssignmentList assignment = new AssignmentList();
        assignment.addItem(assignment1);
        assignment.addItem(assignment2);
        ArrayList item = new ArrayList<>();
        item.add(assignment1);
        item.add(assignment2);
        Assert.assertEquals(item, assignment.getItemList());
    }

    @Test
    public void testComputeGrade() {
        Assignment assignment1 = new Assignment("Assignment1", 12, 9, 23, 00);
        Assignment assignment2 = new Assignment("Assignment2", 11, 4, 15, 30);
        assignment1.setTotalWeight(1.2);
        assignment1.setScore(18.0);
        assignment1.setTotalPoints(40.0);
        assignment2.setTotalWeight(1.5);
        assignment2.setScore(12.0);
        assignment2.setTotalPoints(34.0);
        AssignmentList assignment = new AssignmentList();
        assignment.addItem(assignment1);
        assignment.addItem(assignment2);
        double Expected = ((18.0 * 1.2) + (12.0 * 1.5)) / (1.5 + 1.2);
        double actual = assignment.computeCourseGrade();
        Assert.assertEquals(Expected, actual, 0.0);
    }

    @Test
    public void TesttoString() {
        Assignment assignment1 = new Assignment("Assignment1", 12, 9, 23, 00);
        Assignment assignment2 = new Assignment("Assignment2", 11, 4, 15, 30);
        assignment1.setTotalWeight(1.2);
        assignment1.setScore(18.0);
        assignment1.setTotalPoints(40.0);
        assignment2.setTotalWeight(1.5);
        assignment2.setScore(12.0);
        assignment2.setTotalPoints(34.0);
        AssignmentList assignment = new AssignmentList();
        assignment.addItem(assignment1);
        assignment.addItem(assignment2);
        String Expected = "Unit Testing(Date: 12.9 at 23:0): score=18.0; totalPoints=40.0; totalWeight=1.2}\n" +
                "Unit Testing(Date: 11.4 at 15:30): score=12.0; totalPoints=34.0; totalWeight=1.5}\n";
        String Actual = assignment.toString();
        Assert.assertEquals(Expected, Actual);
    }
}