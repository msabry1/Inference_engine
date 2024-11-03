package inference.rules;

import expression.Expression;
import expression.LogicalExpression;

public class DisjunctiveSyllogism implements InferenceRule {
    @Override
    public boolean matches(Expression exp1, Expression exp2) {
        String representation1 = exp1.getRepresentation();
        String representation2 = exp2.getRepresentation();

        if (representation1.contains("v") && representation2.startsWith("~")) {
            String[] parts = representation1.split("v");
            String firstPart = parts[0].trim();
            String secondPart= parts[1].trim();

            return representation2.trim().equals("~" + firstPart) ||
                    representation2.trim().equals("~" + secondPart);
        }
        return false;
    }

    @Override
    public Expression apply(Expression exp1, Expression exp2) {
        String representation1 = exp1.getRepresentation();

        String[] parts = representation1.split("v");
        String firstPart = parts[0].trim();
        String secondPart= parts[1].trim();

        if (exp2.getRepresentation().equals("~" + firstPart))
            return new LogicalExpression(secondPart);
        else
            return new LogicalExpression(firstPart);
    }
}
