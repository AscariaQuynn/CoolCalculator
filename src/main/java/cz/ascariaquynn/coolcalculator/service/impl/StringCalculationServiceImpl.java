package cz.ascariaquynn.coolcalculator.service.impl;

import cz.ascariaquynn.coolcalculator.model.api.CalculationResponse;
import cz.ascariaquynn.coolcalculator.service.CalculationService;
import org.springframework.stereotype.Service;

@Service
public class StringCalculationServiceImpl implements CalculationService {

    @Override
    public CalculationResponse calculate(long number) {
        String numStr = Long.toString(number);
        String step1 = moveRight(numStr);
        long step2 = processAndDivide(step1);
        return new CalculationResponse(step2);
    }

    private String moveRight(String number) {
        // - všechny číslice menší 3 (včetně) posune o jednu pozici doprava. Např: 43256791 => 45326791
        char[] numArr = number.toCharArray();
        for (int i = numArr.length - 2; i >= 0; i--) {
            if (numArr[i] <= '3') {
                char temp = numArr[i];
                numArr[i] = numArr[i + 1];
                numArr[i + 1] = temp;
            }
        }
        return new String(numArr);
    }

    private long processAndDivide(String number) {
        // - všechny číslice 8 a 9 vynásobí 2. Např.: 45326791 => 453267181
        // - všechny číslice 7 smaže: Např: 453267181 => 45326181
        // - ve výsledném čísle spočte počet sudých číslic a tímto počtem výsledné číslo vydělí a zaokrouhlí dolů na celá čísla. Např: 45326181 / 4 => 11331545
        StringBuilder processedNumber = new StringBuilder();
        long[] evenCount = {0};
        number.chars()
            .filter(c -> c - '0' != 7)
            .forEach(c -> {
                int digit = c - '0';
                digit *= digit >= 8 && digit <= 9 ? 2 : 1;
                evenCount[0] += digit % 2 == 0 ? 1 : 0;
                processedNumber.append(digit);
            });
        // Dělení s kontrolou dělení nulou; Dělení je celočíselné a zaokrouhluje se směrem dolů automaticky
        return evenCount[0] > 0 ? Long.parseLong(processedNumber.toString()) / evenCount[0] : 0;
    }
}
