
interface OperationStrategy {
    double calculate(double num1, double num2);
}


class AdditionStrategy implements OperationStrategy {
    @Override
    public double calculate(double num1, double num2) {
        return num1 + num2;
    }
}

class MultiplicationStrategy implements OperationStrategy {
    @Override
    public double calculate(double num1, double num2) {
        return num1 * num2;
    }
}

class DivisionStrategy implements OperationStrategy {
    @Override
    public double calculate(double num1, double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Division by zero!");
        }
        return num1 / num2;
    }
}


class Calculator {
    private OperationStrategy strategy;

    public Calculator(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    public double executeStrategy(double num1, double num2) {
        return strategy.calculate(num1, num2);
    }
}


  public class Calc  
{
    public static void main(String[] args) {
        
        Calculator calculator = new Calculator(new AdditionStrategy());
        double result = calculator.executeStrategy(5, 3);
        System.out.println("Результат сложения: " + result);

       
        calculator.setStrategy(new MultiplicationStrategy());
        result = calculator.executeStrategy(5, 3);
        System.out.println("Результат умножения: " + result);

   
        calculator.setStrategy(new DivisionStrategy());
        result = calculator.executeStrategy(10, 2);
        System.out.println("Результат деления: " + result);
    }
}
