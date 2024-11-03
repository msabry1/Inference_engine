# Inference Engine

Lab assignment for **CS214: Discrete Structures**, featuring an inference engine that applies various logical inference rules.

## Overview

This project implements an inference engine that applies standard logical rules to evaluate statements and derive conclusions from given premises.

## Features

- **Inference Engine**: Applies logical rules to make inferences based on provided statements.
- **Supported Inference Rules**:
    - **Modus Ponens**: If  `P → Q` and  `P` are true, then  `Q` must be true.
    - **Modus Tollens**: If  `P → Q` and  `~Q` are true, then  `~P` must be true.
    - **Hypothetical Syllogism**: If  `P → Q` and  `Q → R` are true, then  `P → R` is true.
    - **Disjunctive Syllogism**: If  `P v Q` and  `~P` are true, then  `Q` must be true.
    - **Resolution**: Combines clauses to simplify and derive conclusions, often used in propositional logic.

## Extending the Inference Engine

You can add custom rules to the inference engine by implementing the `InferenceRule` interface and then addingthis rule using `addRule`



