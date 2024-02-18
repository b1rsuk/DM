package org.example;

import org.example.tables.LogicalRelationshipTable;
import org.example.tables.TruthLogicalFunctionTable;

public class Main {

    public static void main(String[] args) {
        Combination[] logicalRelationshipCombination = {
                new Combination(true, true, true),
                new Combination(true, false, false),
                new Combination(false, true, true),
                new Combination(false, false, false),
        };

        Combination[] truthLogicalCombination = {
                new Combination(true, true, true),
                new Combination(true, true, false),
                new Combination(true, false, true),
                new Combination(true, false, false),
                new Combination(false, true, true),
                new Combination(false, true, false),
                new Combination(false, false, true),
                new Combination(false, false, false),
        };

        LogicalRelationshipTable logicalRelationshipTable = new LogicalRelationshipTable(logicalRelationshipCombination);
        TruthLogicalFunctionTable truthLogicalFunctionTable = new TruthLogicalFunctionTable(truthLogicalCombination, FVariant.f2());

        System.out.println(logicalRelationshipTable);
        System.out.println(truthLogicalFunctionTable);
    }

}