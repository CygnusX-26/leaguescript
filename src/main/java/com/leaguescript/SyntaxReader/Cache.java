package com.leaguescript.SyntaxReader;

import java.util.Stack;

/**
 * caches objects for more advanced expressions
 */
public class Cache {
    private Stack<Object> boolStack = new Stack<Object>();
    private Stack<Object> itemStack = new Stack<Object>();
    private Stack<String> operatorStack = new Stack<String>();
    private Stack<String> logicStack = new Stack<String>();
    private Stack<Object> calculationStack = new Stack<Object>();
    private Stack<Object> numbersStack = new Stack<Object>();

    public Stack<String> getOperatorStack(){
        return operatorStack;
    }

    public void pushBoolStack(Object bool){
        boolStack.push(bool);
    }
    public void pushItemStack(Object item){
        itemStack.push(item);
    }
    public void pushOperatorStack(String operator){
        operatorStack.push(operator);
    }
    public void pushLogicStack(String logic){
        logicStack.push(logic);
    }
    public void pushCalculationStack(Object calculation){
        calculationStack.push(calculation);
    }
    public void pushNumbersStack(Object number){
        numbersStack.push(number);
    }


    public Object popBoolStack(){
        return boolStack.pop();
    }
    public Object popItemStack(){
        return itemStack.pop();
    }
    public String popOperatorStack(){
        return operatorStack.pop();
    }
    public String popLogicStack(){
        return logicStack.pop();
    }
    public Object popCalculationStack(){
        return calculationStack.pop();
    }
    public Object popNumbersStack(){
        return numbersStack.pop();
    }
}
