package calc;

import Ice.Current;
import utils._CalculatorDisp;

/**
 * Calculator with gcd and lcm methods.
 *
 * @author urko
 */
public class Calculator extends _CalculatorDisp {

    @Override
    public long gcd(long x, long y, Current __current) {
        if ((x == 0) || (y == 0)) return x + y;
        return gcd(y, x % y);
    }

    @Override
    public long lcm(long x, long y, Current __current) {
        return x * (y / gcd(x, y));
    }

}
