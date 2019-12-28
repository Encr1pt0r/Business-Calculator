
public class Calculations extends ControlFrame {
    
    //////////////////////////////// Unit1 ////////////////////////////////////
    
    static double getUnitContribution(double input1, double input2) {
        return input1 * input2;
    }// Contribution per unit = Price - Variable Costs
    
    static double getTotalContribution(double input1, double input2) {
        return input1 * input2;
    }// Total Contribution = Contribution per unit * no. sold
    
    static double getBreakevenPoint(double input1, double input2) {
        return input1 / input2;
    }// Breakeven Point = Fixed costs / Contribution
    
    static double getMarginOfSafety(double input1, double input2) {
        return input1 - input2;
    }// Margin of Safety = Current level of output - Breakeven Point
    
    //////////////////////////////// Unit2 ////////////////////////////////////
    
    static double getPED(double input1, double input2) {
        return input1 / input2;
    }// PED = Percent change in demand / Percent change in price
    
    static double getIED(double input1, double input2) {
        return input1 / input2;
    }// IED = Percent change in demand / Percent change in income
    
    static double getPercentChange(double input1, double input2) {
        return ((input1 - input2) / input2) * 100;
    }// Percent Change = (difference between 2 numbers / original number) * 100
    
    //////////////////////////////// Unit3 ////////////////////////////////////
    
    static double getProfit(double input1, double input2) {
        return input1 - input2;
    }// Profit = Total Revenue - Total Costs

    static double getSalesRevenue(double input1, double input2) {
        return input1 * input2;
    }// Sales Revenue = Price * Quantiy Sold

    static double getTotalCost(double input1, double input2) {
        return input1 + input2;
    }// Total Cost = Variable Costs + Fixed Costs

    static double getAverageCost(double input1, double input2) {
        return input1 / input2;
    }// Average (unit) costs = Total Costs / no. of units sold
    
    static double getCapacityUtilisation(double input1, double input2) {
        return (input1 / input2) * 100;
    }// Capacity Utilisation = (Current Capacity / Max possible capacity) * 100
    
    //////////////////////////////// Unit4 ////////////////////////////////////
    
    static double getGrossProfit(double input1, double input2) {
        return input1 - input2;
    }// Gross Profit = Revenue - Cost of sales
    
    static double getOperatingProfit(double input1, double input2) {
        return input1 - input2;
    }// Operating Profit = Gross Profit - Operating expences
    
    static double getNetProfit(double input1, double input2) {
        return input1 - input2;
    }// Net Profit = Operating Profit - Tax
    
    //////////////////////////////// Unit5 ////////////////////////////////////
    
    static double getGearingRatio(double input1, double input2) {
        return (input1 / input2) * 100;
    }// Gearing ratio = (Non-Current Liabilities / Capital Employed) * 100
    
    static double getCurrentRatio(double input1, double input2) {
        return input1 / input2;
    }// Current Ratio = Current Liabilites / Non-Current Liabilites
    
    static double getAcidTest(double input1, double input2, double input3) {
        return (input1 - input2) / input3;
    }// Acid Test Ratio = (Current Liabilites - Stock) / Non-Current Liabilites
    
    static double getROCE(double input1, double input2) {
        return (input1 / input2) * 100;
    }// ROCE = (Operating profit / Capital Empolyed) * 100
    
    /////////////////////////////Other methods/////////////////////////////////

    static double reverse(double input1) {
        return input1 * -1;
    }// Reverses the sign of its input
}
