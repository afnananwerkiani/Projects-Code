import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class ProjectTest {
    private static final String NAME = "Unit Testing";
    private static final int DAY = 1;
    private static final int MONTH = 9;
    private static final int HOUR = 23;
    private static final int MINUTE = 59;
    private static final double SCORE = 0.93;
    private static final double TOTALPOINTS = 0.99;
    private static final double TOTALWEIGHT = 0.30;
    private static final double ACCURACY = 0.000001;
    private static Project item;
    private static final String specification = "UnitTesting.pdf";
    private static final String datafile= "Assignment.csv";
    @Test
    public void ProjectToStringTest() {
        Project project = new Project("Cal", 12, 01, 23, 00, "UnitTesting.pdf", "Assignment.csv");
        project.setScore(0.78);
        project.setTotalPoints(0.99);
        project.setTotalWeight(0.30);
        String Expected = "Unit Testing(Date: 12.1 at 23:0): score=0.78; totalPoints=0.99; totalWeight=0.3, Specification on= UnitTesting.pdf, Datafile= Assignment.csv";
        String actual = project.toString();

        assertEquals(Expected, actual);
    }
}