package mortgageCalculations;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class mortgageController {

    public final BigDecimal defaultIncome = new BigDecimal(0);

    @GetMapping("/api/mortgageCalculations-check")
    public Mortgage mortgage(){
        Mortgage calculator = new Mortgage();
        calculator.setLoanValue();
        calculator.setIncome();
        calculator.setHomeValue();
        calculator.calculateMonthlyCosts();
        return calculator;
    }

}
