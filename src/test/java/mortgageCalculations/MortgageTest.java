package mortgageCalculations;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;
import java.math.MathContext;

public class MortgageTest {

    private BigDecimal income;
    private BigDecimal loanValue;
    private BigDecimal homeValue;
    private BigDecimal yearlyInterestRate;
    private int paymentTermInYears;
    private BigDecimal monthlyCosts;

    private mortgageController testController = new mortgageController();

    @Before
    public void setUp (){
        this.loanValue = new BigDecimal(200000);
        this.income = new BigDecimal(50000);
        this.homeValue = new BigDecimal(200000);;
        this.yearlyInterestRate = new BigDecimal(0.027);
        this.paymentTermInYears = 30;
    }

    @Test
    public void mortgageIsAccepted(){
        Mortgage mortgage = testController.mortgageCheck(loanValue, income, homeValue, yearlyInterestRate, paymentTermInYears);
        assert(mortgage.mortgageIsApproved());
    }

    @Test
    public void monthlyMortgagePayment(){
        Mortgage mortgage = testController.mortgageCheck(loanValue, income, homeValue, yearlyInterestRate, paymentTermInYears);
        BigDecimal monthlyPayment = mortgage.calculateMonthlyCosts();
        System.out.println(monthlyPayment.toString());
        System.out.println(new BigDecimal(811.20).round(new MathContext(5)).toString());
        assert(monthlyPayment.equals(new BigDecimal(811.20).round(new MathContext(5))));
    }
}
