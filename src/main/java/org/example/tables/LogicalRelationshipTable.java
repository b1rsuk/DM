package org.example.tables;

import org.example.Combination;
import org.example.TruthOperation;

public class LogicalRelationshipTable extends Table {

    private static final Object[] headers = {
            "A",
            "B",
            "NOT a",
            "a AND b",
            "a OR b",
            "A XOR b"
    };

    public LogicalRelationshipTable(Combination[] combination) {
        super(headers, combination);
    }

    void generateRow(Combination combination) {

        boolean a = combination.isA();
        boolean b = combination.isB();
        Object[] newRow = {
                TruthOperation.convertBooleanToInt(a),
                TruthOperation.convertBooleanToInt(b),
                TruthOperation.convertBooleanToInt(TruthOperation.NOT(a)),
                TruthOperation.convertBooleanToInt(TruthOperation.AND(a, b)),
                TruthOperation.convertBooleanToInt(TruthOperation.OR(a, b)),
                TruthOperation.convertBooleanToInt(TruthOperation.XOR(a, b))
        };

        addRow(newRow);
    }

}
