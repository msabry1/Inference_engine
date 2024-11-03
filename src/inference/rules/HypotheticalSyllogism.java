package inference.rules;

import expression.Expression;
import expression.LogicalExpression;

public class HypotheticalSyllogism implements InferenceRule {


    @Override
    public boolean matches(Expression exp1, Expression exp2) {
        String representation1 = exp1.getRepresentation();
        String representation2 = exp2.getRepresentation();

        if (representation1.contains(">") && representation2.contains(">")) {

            String[] representation_arr1 = representation1.split(">");
            String[] representation_arr2 = representation2.split(">");

            return representation_arr1[1].trim()
                    .equals(representation_arr2[0].trim())
                    &&
                    !(representation_arr1[0].trim()
                    .equals(representation_arr2[1].trim()));
        }
        return false;
    }

    @Override
    public Expression apply(Expression exp1, Expression exp2) {
        String representation1 = exp1.getRepresentation();
        String representation2 = exp2.getRepresentation();

        return new LogicalExpression(
                representation1.split(">")[0].trim() +
                            " > " +
                            representation2.split(">")[1].trim()
        );
    }
}
