package cz.ascariaquynn.coolcalculator.controller;

import cz.ascariaquynn.coolcalculator.model.api.CalculationResponse;
import cz.ascariaquynn.coolcalculator.service.impl.StringCalculationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/calculation")
public class CalculationController {

    private final StringCalculationServiceImpl calculationService;

    @GetMapping("/calculate/{number}")
    public CalculationResponse calculate(@PathVariable long number) {
        return calculationService.calculate(number);
    }
}
