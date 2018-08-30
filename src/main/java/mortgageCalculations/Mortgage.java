package mortgageCalculations;

import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Mortgage {

    //variables set by User
    private BigDecimal income;

    private BigDecimal loanValue;

    private BigDecimal homeValue;

    private BigDecimal yearlyInterestRate;

    private int paymentTermInYears;

    private BigDecimal monthlyCosts;

    private static int ROUNDING_MODE = BigDecimal.ROUND_HALF_EVEN;

    private MathContext precision = new MathContext(5);

    //Maximum loan allowed is 4 times the income
    private final BigDecimal incomeBasedLimit = new BigDecimal(4);

    /////////////////////////////Business Rules//////////////////////////////////////////

    public Boolean mortgageIsApproved(){
        if (loanValueInAccordanceWithIncomeBasedLimit() && loanValueSmallerThanHomeValue()){
            return true;
        }else{
            return false;
        }
    }

    public Boolean loanValueInAccordanceWithIncomeBasedLimit (){
        BigDecimal maxLoanAllowed = getIncome().multiply(incomeBasedLimit);
        return (getLoanValue().compareTo(maxLoanAllowed) <= 0);
    }

    public Boolean loanValueSmallerThanHomeValue(){
        return (getLoanValue().compareTo(getHomeValue()) <= 0);
    }

    /////////////////////////////Calculation///////////////////////////////////////////////
    public BigDecimal calculateMonthlyCosts(){

        int paymentTermInMonths = getPaymentTermInYears()*12;
        BigDecimal monthlyInterestRate = getYearlyInterestRate().divide(new BigDecimal(12),ROUNDING_MODE);
        BigDecimal monthlyPayment;

        //Interest in decimal is monthlyInterest + 1
        BigDecimal interestInDecimal = monthlyInterestRate.add(new BigDecimal(1));

        monthlyPayment = homeValue.multiply((monthlyInterestRate.multiply(interestInDecimal.pow(paymentTermInMonths)))
                                  .divide(interestInDecimal.pow(paymentTermInMonths).subtract(new BigDecimal(1)),ROUNDING_MODE));

        return monthlyPayment.round(precision);
    }

    ///////////////////////////////getters and setters///////////////////////////////
    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public BigDecimal getLoanValue() {
        return loanValue;
    }

    public void setLoanValue(BigDecimal loanValue) {
        this.loanValue = loanValue;
    }

    public BigDecimal getHomeValue() {
        return homeValue;
    }

    public void setHomeValue(BigDecimal homeValue) {
        this.homeValue = homeValue;
    }

    public int getPaymentTermInYears() {
        return paymentTermInYears;
    }

    public void setPaymentTermInYears(int paymentTermInYears) {
        this.paymentTermInYears = paymentTermInYears;
    }

    public BigDecimal getYearlyInterestRate() {
        return yearlyInterestRate;
    }

    public void setYearlyInterestRate(BigDecimal yearlyInterestRate) {
        this.yearlyInterestRate = yearlyInterestRate;
    }

    public BigDecimal getIncomeBasedLimit() {
        return incomeBasedLimit;
    }

    public BigDecimal getMonthlyCosts() {
        return monthlyCosts;
    }

    public void setMonthlyCosts(BigDecimal monthlyCosts) {
        this.monthlyCosts = monthlyCosts;
    }
}
