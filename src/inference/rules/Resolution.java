package inference.rules;

import expression.Expression;
import expression.LogicalExpression;

public class Resolution implements InferenceRule {
    @Override
    public boolean matches(Expression exp1, Expression exp2) {
        String representation1 = exp1.getRepresentation();
        String representation2 = exp2.getRepresentation();

        if (representation1.contains("v") && representation2.contains("v")) {
            String repOnePartOne = representation1.split("v")[0].trim();

            String repTwoPartOne = representation2.split("v")[0].trim();

            return repTwoPartOne.equals("~" + repOnePartOne) ;
        }
        return false;
    }

    @Override
    public Expression apply(Expression exp1, Expression exp2) {
        String representation1 = exp1.getRepresentation();
        String representation2 = exp2.getRepresentation();
        String repOnePartTwo = representation1.split("v")[1].trim();
        String repTwoPartTwo = representation2.split("v")[1].trim();

        return new LogicalExpression(repOnePartTwo + " v " + repTwoPartTwo);
    }
}