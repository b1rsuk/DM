package org.example;

import org.example.tables.LogicFunction;

import static org.example.TruthOperation.AND;
import static org.example.TruthOperation.EQU;
import static org.example.TruthOperation.IMP;

public final class FVariant {

    public static LogicFunction f2() {
        return (a, b, c) -> EQU(IMP(a,AND(b, c)),AND(IMP(a, b),IMP(a, c)));
    }


}