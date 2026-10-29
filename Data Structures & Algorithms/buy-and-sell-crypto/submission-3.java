class Solution {
    public int maxProfit(int[] prices) {

        int maxprofit = 0, buy_price = prices[0];

        for(int i = 1; i < prices.length; i++){

            int currentprofit = prices[i] - buy_price;

            if(currentprofit > maxprofit){

                maxprofit = currentprofit;
            }

            if(prices[i] < buy_price){

                buy_price = prices[i];
            }
        }

        return maxprofit;
        
    }
}
