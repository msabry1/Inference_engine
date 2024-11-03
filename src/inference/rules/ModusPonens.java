package inference.rules;

import expression.Expression;
import expression.LogicalExpression;


public class ModusPonens implements InferenceRule {
    @Override
    public boolean matches(Expression exp1, Expression exp2) {
        String representation1 = exp1.getRepresentation();
        String representation2 = exp2.getRepresentation();

        if (representation1.contains(">")) {
            return representation1
                    .split(">")[0].trim()
                    .equals(representation2.trim());
        }
        return false;
    }

    @Override
    public Expression apply(Expression exp1, Expression exp2) {
        String result = exp1.getRepresentation().split(">")[1].trim();
        return new LogicalExpression(result);
    }
}
