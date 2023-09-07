package sber.code.beautifulcode.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import sber.code.beautifulcode.schemas.CheckBracketsRequest;
import sber.code.beautifulcode.schemas.CheckBracketsResponse;
import sber.code.beautifulcode.service.CheckBracketsServiceImpl;
import sber.code.beautifulcode.utils.EndPoint;
@Tag(name = "Контроллер для проверки скобок")
@RestController
@RequestMapping(EndPoint.api)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CheckBracketsController {
    CheckBracketsServiceImpl checkBracketsServiceImpl;

    public CheckBracketsController(CheckBracketsServiceImpl checkBracketsServiceImpl) {
        this.checkBracketsServiceImpl = checkBracketsServiceImpl;
    }
    @Operation(
            summary = "Проверка текста",
            description = "Позволяет проверить текст на корректность скобок"
    )
    @PostMapping(value = EndPoint.checkBrackets)
    public CheckBracketsResponse checkBrackets(@RequestBody() CheckBracketsRequest request) {
        if (request.getText().isEmpty()) new CheckBracketsResponse(true);
        boolean isCorrect = checkBracketsServiceImpl.checkTextOnBrackets(request.getText());
        return new CheckBracketsResponse(isCorrect);
    }
}
