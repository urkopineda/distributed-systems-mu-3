package calc;

import Ice.Current;
import utils.CalculatorPrx;
import utils._CalculatorManagerDisp;

import java.util.ArrayList;

/**
 * A simple Calculator Manager.
 *
 * @author urko
 */
public class Manager extends _CalculatorManagerDisp {

    private int i = -1;
    private ArrayList<CalculatorPrx> list = new ArrayList<>();

    public Manager(ArrayList<CalculatorPrx> list) {
        this.list = list;
    }

    @Override
    public CalculatorPrx giveMeOneCalculatorReference(Current __current) {
        increment();
        System.out.println("Using " + i + " calculator...");
        return list.get(i);
    }

    private void increment() {
        i++;
        if (i >= list.size()) i = 0;
    }

}
