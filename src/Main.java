
import expression.LogicalExpression;
import inference.InferenceEngine;
import inference.InferenceEngineImpl;
import inference.rules.*;


public class Main {
    public static void main(String[] args) {

        InferenceEngine inferenceEngine = new InferenceEngineImpl(
            new ModusPonens(),
            new ModusTollens(),
            new HypotheticalSyllogism(),
            new DisjunctiveSyllogism(),
            new Resolution()
        );

        System.out.println(inferenceEngine.applyRules(
                new LogicalExpression("p > q"),
                new LogicalExpression("p")
        ).getRepresentation()); // q

        System.out.println(inferenceEngine.applyRules(
                new LogicalExpression("p > q"),
                new LogicalExpression("~q")
        ).getRepresentation()); // ~p

        System.out.println(inferenceEngine.applyRules(
                new LogicalExpression("p > q"),
                new LogicalExpression("q > r")
        ).getRepresentation()); // p > r

        System.out.println(inferenceEngine.applyRules(
                new LogicalExpression("p v q"),
                new LogicalExpression("~p")
        ).getRepresentation()); // q

        System.out.println(inferenceEngine.applyRules(
                new LogicalExpression("p v q"),
                new LogicalExpression("~p v r")
        ).getRepresentation()); // q v r
    }
}








//public class com.learn.Main { // modusponens
//    public static void main(String[] args) {
//
//        Expression exp1 = new LogicalExpression("p > q") ;
//        Expression exp2 = new LogicalExpression("p") ;
//
//        InferenceRule modusPonens = new ModusPonens();
//        System.out.println(modusPonens.apply(exp1, exp2).getRepresentation());
//    }
//}

//public class com.learn.Main { // modustollens
//    public static void main(String[] args) {
//
//        Expression exp1 = new LogicalExpression("p > q") ;
//        Expression exp2 = new LogicalExpression("~q") ;
//
//        ModusTollens modusTollens = new ModusTollens();
//        System.out.println(modusTollens.apply(exp1, exp2).getRepresentation());
//    }
//}


//public class com.learn.Main { // HypotheticalSyllogism
//    public static void main(String[] args) {
//
//        Expression exp1 = new LogicalExpression("p > q") ;
//        Expression exp2 = new LogicalExpression("q > r") ;
//
//        InferenceRule hypotheticalSyllogism = new HypotheticalSyllogism();
//        if (hypotheticalSyllogism.matches(exp1, exp2))
//            System.out.println(hypotheticalSyllogism.apply(exp1, exp2).getRepresentation());
//    }
//}

//public class com.learn.Main { // DisjunctiveSyllogism
//    public static void main(String[] args) {
//
//        Expression exp1 = new LogicalExpression("p v q") ;
//        Expression exp2 = new LogicalExpression("~q") ;
//
//        InferenceRule disjunctiveSyllogism = new DisjunctiveSyllogism();
//        if (disjunctiveSyllogism.matches(exp1, exp2))
//            System.out.println(disjunctiveSyllogism.apply(exp1, exp2).getRepresentation());
//    }
//}


//public class com.learn.Main { // resolution
//    public static void main(String[] args) {
//
//        Expression exp1 = new LogicalExpression("p v q") ;
//        Expression exp2 = new LogicalExpression("~p v o") ;
//
//    InferenceRule resolution = new Resolution();
//        if (resolution.matches(exp1, exp2))
//            System.out.println(resolution.apply(exp1, exp2).getRepresentation());
//    }
//}
