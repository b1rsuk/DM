package org.example.tables;

import org.example.Combination;
import org.example.FVariant;
import org.example.TruthOperation;

public class TruthLogicalFunctionTable extends Table {

    private static final Object[] headers = {
            "A",
            "B",
            "C",
            "F2"
    };

    public TruthLogicalFunctionTable(Combination[] combination, LogicFunction logicFunction) {
        super(headers, combination, logicFunction);
    }

    void generateRow(Combination combination) {
        boolean a = combination.isA();
        boolean b = combination.isB();
        boolean c = combination.isC();
        boolean logicFunction = super.logicFunction.doOperation(a, b, c);

        Object[] newRow = {
                TruthOperation.convertBooleanToInt(a),
                TruthOperation.convertBooleanToInt(b),
                TruthOperation.convertBooleanToInt(c),
                TruthOperation.convertBooleanToInt(logicFunction)
        };

        super.addRow(newRow);
    }

}
