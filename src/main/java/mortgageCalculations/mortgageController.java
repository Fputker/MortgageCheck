package mortgageCalculations;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class mortgageController {

    public final BigDecimal defaultIncome = new BigDecimal(0);

    @GetMapping("/api/mortgageCalculations-check")
    public Mortgage mortgageCheck(@RequestParam BigDecimal loanValue,
                                  @RequestParam BigDecimal income,
                                  @RequestParam BigDecimal homeValue,
                                  @RequestParam BigDecimal interestRate,
                                  @RequestParam int paymenttermInYears ){

        Mortgage mortgage = new Mortgage();

        //Set all necessary fields
        mortgage.setLoanValue(loanValue);
        mortgage.setIncome(income);
        mortgage.setHomeValue(homeValue);
        mortgage.setYearlyInterestRate(interestRate);
        mortgage.setPaymentTermInYears(paymenttermInYears);

        mortgage.calculateMonthlyCosts();
        return mortgage;
    }

}
