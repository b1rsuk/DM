package org.example;

import org.example.tables.LogicFunction;

public class Function {
    Object name;
    LogicFunction logicFunction;

    public Function(String name, LogicFunction logicFunction) {
        this.name = name;
        this.logicFunction = logicFunction;
    }

    public Object getName() {
        return name;
    }

    public LogicFunction getLogicFunction() {
        return logicFunction;
    }
}