package inference;

import expression.Expression;
import inference.rules.InferenceRule;

public interface InferenceEngine {
    void addRule(InferenceRule rule);

    Expression applyRules(Expression exp1,Expression exp2);
}