public class Driver {
	public static void main(String[] args)
    {
        AssignmentList list = new AssignmentList();
        Assignment assignment1= new Assignment("Assgnment 1", 7, 27, 1, 45);
        Assignment assignment2= new Lab("Lab 2", 6, 25, 14, 30, "UnitTesting.pdf");
        Assignment assignment3= new Project("Project 3", 4, 26, 17, 45, "Java Testing", "Assignment.csv");
        assignment1.setTotalPoints(100.0);
        assignment1.setTotalWeight(3.0);
        assignment1.setScore(85.0);
        assignment2.setTotalPoints(50.0);
        assignment2.setTotalWeight(8.6);
        assignment2.setScore(43.0);
        assignment3.setTotalPoints(30.0);
        assignment3.setTotalWeight(5.6);
        assignment3.setScore(24.0);
        list.addItem(assignment1);
        list.addItem(assignment2);
        list.addItem(assignment3);
        System.out.println("The Total calculated course grade is: "+ list.computeCourseGrade());
        System.out.println(list.toString());
    }
}
