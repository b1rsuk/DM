package org.example;

public final class TruthOperation {

    public static boolean NOT(boolean a) {
        if (a == false) {
            return true;
        }

        return false;
    }

    public static boolean IMP(boolean a, boolean b) {
        if (a == true && b == false) {
            return false;
        }

        return true;
    }

    public static boolean EQU(boolean a, boolean b) {
        if (a == b) {
            return true;
        }

        return false;
    }

    public static boolean AND(boolean a, boolean b) {
        if (a == true) {
            if (b == true) {
                return true;
            }
        }
        return false;
    }


    public static boolean OR(boolean a, boolean b) {
        if (a == true) {
            return true;
        }
        if (b == true) {
            return true;
        }

        return false;
    }

    public static boolean XOR(boolean a, boolean b) {
        if (a != b) {
            return true;
        }

        return false;
    }

    public static int convertBooleanToInt(boolean b) {
        return b? 1 : 0;
    }

}

