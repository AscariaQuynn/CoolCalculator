package cz.ascariaquynn.coolcalculator.service;

import cz.ascariaquynn.coolcalculator.model.api.CalculationResponse;

public interface CalculationService {

    CalculationResponse calculate(long number);
}
