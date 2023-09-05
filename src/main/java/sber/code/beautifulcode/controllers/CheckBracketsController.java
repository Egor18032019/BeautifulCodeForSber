package sber.code.beautifulcode.controllers;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import sber.code.beautifulcode.schemas.CheckBracketsRequest;
import sber.code.beautifulcode.schemas.CheckBracketsResponse;
import sber.code.beautifulcode.service.CheckBracketsService;
import sber.code.beautifulcode.utils.EndPoint;

@RestController
@RequestMapping(EndPoint.api)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CheckBracketsController {
    CheckBracketsService checkBracketsService;

    public CheckBracketsController(CheckBracketsService checkBracketsService) {
        this.checkBracketsService = checkBracketsService;
    }

    @PostMapping(value = EndPoint.checkBrackets)
    public CheckBracketsResponse checkBrackets(@RequestBody() CheckBracketsRequest request) {
        if (request.getText().isEmpty()) new CheckBracketsResponse(true);
        boolean isCorrect = checkBracketsService.checkBrackets(request.getText());
        return new CheckBracketsResponse(isCorrect);
    }
}
