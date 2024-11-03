package inference.rules;

import expression.Expression;
import expression.LogicalExpression;

public class ModusTollens implements InferenceRule {
    @Override
    public boolean matches(Expression exp1, Expression exp2) {
        String representation1 = exp1.getRepresentation();
        String representation2 = exp2.getRepresentation();

        if (representation1.contains(">") && representation2.startsWith("~")) {
            return representation2.trim()
                    .equals(
                            "~" + representation1.split(">")[1].trim()
                    );
        }
        return false;
    }

    @Override
    public Expression apply(Expression exp1, Expression exp2) {
        return new LogicalExpression(
                "~" +
                            exp1
                                .getRepresentation()
                                .split(">")[0]
                                .trim()
        ) ;
    }
}
