module utils
{
    interface Calculator
    {
        long gcd(long x, long y);
        long lcm(long x, long y);
    };

    interface CalculatorManager
    {
        Calculator *giveMeOneCalculatorReference();
    };
};