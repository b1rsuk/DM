package org.example.tables;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import org.example.Combination;

import java.util.List;

public abstract class Table {

    private final AsciiTable asciiTable;
    protected LogicFunction logicFunction;

    protected Table(Object[] headers, Combination[] combination, LogicFunction logicFunction) {
        this.asciiTable = new AsciiTable();
        this.logicFunction = logicFunction;

        generateTable(headers, combination);
    }


    protected Table(Object[] headers, Combination[] combination) {
        this.asciiTable = new AsciiTable();
        generateTable(headers, combination);
    }
    private void generateTable(Object[] headers, Combination[] combination) {
        prepareTableHeaders(headers);
        completeCombinations(combination);
        asciiTable.addRule();
    }

    private void completeCombinations(Combination[] combination) {
        List.of(combination).forEach(this::generateRow);
    }

    abstract void generateRow(Combination combination);

    private void prepareTableHeaders(Object[] headers) {
        asciiTable.addRule();
        addRow(headers);
        asciiTable.addRule();
    }

    protected void addRow(Object[] rowData) {
        asciiTable.addRow(rowData)
                .setTextAlignment(TextAlignment.CENTER);
    }

    @Override
    public String toString() {
        return this.asciiTable.render();
    }
}
