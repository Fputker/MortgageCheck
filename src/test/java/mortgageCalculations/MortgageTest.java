package mortgage;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.junit.Test;
import java.math.BigDecimal;

public class MortgageCalculatorTest {

    private BigDecimal income;
    private BigDecimal loanValue;
    private BigDecimal homeValue;
    private BigDecimal yearlyInterestRate;
    private int paymentTermInYears;
    private BigDecimal monthlyCosts;

    private CalculatorController testController = new CalculatorController();

    @Test
    public void mortgageIsDeclined(){
        testController.
    }
}
