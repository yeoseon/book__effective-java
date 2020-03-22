public enum Operator {
    ADD("+") {
        public int calculate(int firstNum, int secondNum)
        { return calculator.add(firstNum, secondNum); }
    },
    SUBTRACT("-") {
        public int calculate(int firstNum, int secondNum)
        { return calculator.subtract(firstNum, secondNum); }
    },
    MULTIPLY("*") {
        public int calculate(int firstNum, int secondNum)
        { return calculator.multiple(firstNum, secondNum); }
    },
    DIVISION("/") {
        public int calculate(int firstNum, int secondNum)
        { return calculator.divide(firstNum, secondNum); }
    };

    Calculator calculator = new Calculator();

    private final String value;

    Operator(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }

    public abstract int calculate(int firstNum, int secondNum);
}