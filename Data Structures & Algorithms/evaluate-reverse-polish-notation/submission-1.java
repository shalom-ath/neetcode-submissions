class Solution {
    public int evalRPN(String[] tokens) {

        Stack<String> stack =  new Stack<>();

        for(String el : tokens){

            if(isOperator(el)){

                int el2 = Integer.parseInt(stack.pop());
                int el1 = Integer.parseInt(stack.pop());
                int ans = 0;

                if(el.equals("*")){
                    ans = el1 * el2;
                }

                else if(el.equals("/")){

                    ans = el1 / el2;
                }

                else if(el.equals("-")){

                    ans = el1 - el2;
                }

                else if(el.equals("+")){

                    ans = el1 + el2;
                }

                stack.push(ans+"");

            }

            else{

                //operand

                stack.push(el);
            }
        }

        return Integer.parseInt(stack.peek());
        
    }

    private boolean isOperator(String el){

        if(el.equals("*") || el.equals("/") || el.equals("-") || el.equals("+")){

            return true;
        }

        else{

            return false;
        }
    }
}
