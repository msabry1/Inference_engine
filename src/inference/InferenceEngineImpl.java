package inference;

import expression.Expression;
import inference.rules.InferenceRule;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InferenceEngineImpl implements InferenceEngine {
    private List<InferenceRule> rules;
    public InferenceEngineImpl(InferenceRule... rules) {
        this.rules = new ArrayList<>(Arrays.asList(rules));
    }
    @Override
    public void addRule(InferenceRule rule) {
        rules.add(rule);
    }

    // I removed addExpression because i will have to use each object only onetime
    @Override
    public Expression applyRules(Expression exp1,Expression exp2) {
        for (InferenceRule rule : rules) {
            if (rule.matches(exp1, exp2)) {
                return rule.apply(exp1, exp2);
            }
            else if (rule.matches(exp2, exp1)) {
                return rule.apply(exp2, exp1);
            }
        }
        return null;
    }
}
