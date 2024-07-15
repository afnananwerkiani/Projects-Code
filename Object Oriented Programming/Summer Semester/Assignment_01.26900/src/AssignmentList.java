import java.util.ArrayList;

public class AssignmentList {
    private ArrayList<Assignment> itemList;

    /**
     * Constructor for AssignmentList.
     * Takes in information on the assignment items
     */
    public AssignmentList() {
        itemList = new ArrayList<Assignment>();
    }

    public ArrayList<Assignment> getItemList() {
        return itemList;
    }

    /**
     * Add the assignment items from the Assignment class to the ArrayList
     *
     * @param item has the assignment items from the Assignment class
     */
    public void addItem(Assignment item) {
        itemList.add(item);
    }

    /**
     * Compute the course grade from the assignment items in the list
     * <p>
     * If there are no assignments in the list, then the course grade is zero.
     *
     * @return The course grade
     */
    public double computeCourseGrade() {
        int a = itemList.size();
        if (a == 0) {
            return 0.0;
        }
        double weightedtotal = 0.0;
        double totalweighted = 0.0;
        for (Assignment assignment : itemList) {
            double assignmentWeight = assignment.getTotalWeight();
            double assignmentScore = assignment.getScore();
            weightedtotal += (assignmentScore * assignmentWeight);
            totalweighted += assignmentWeight;
        }
        return weightedtotal / totalweighted;
    }

    /**
     * toString override. Gives all information about the AssignmentList.
     *
     * @return All information about the assignment items
     */
    public String toString() {
        String out = "";

        // Loop over all of the items in the list.
        for (int i = 0; i < itemList.size(); ++i) {
            out += itemList.get(i).toString() + "\n";
        }

        return out;
    }
}