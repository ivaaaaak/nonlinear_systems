package methods;

import functions.Function;

public record NonlinearSystem(int n, Function... f) {

    public Function getFunctionByNumber(int num) {
        return f[num];
    }
}
