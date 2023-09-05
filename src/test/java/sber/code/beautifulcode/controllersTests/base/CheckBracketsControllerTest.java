package sber.code.beautifulcode.controllersTests.base;


import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import sber.code.beautifulcode.BeautifulCodeApplication;
import sber.code.beautifulcode.schemas.CheckBracketsRequest;
import sber.code.beautifulcode.utils.EndPoint;
import sber.code.beautifulcode.utils.JsonUtil;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ContextConfiguration(classes = {BeautifulCodeApplication.class})
@WebAppConfiguration
public class CheckBracketsControllerTest extends AbstractRestControllerTest {

    @Test
    void checkCorrectBrackets() throws Exception {
        CheckBracketsRequest request = new CheckBracketsRequest("Это (!) корректный случай (!) !");
        perform(post(EndPoint.api + EndPoint.checkBrackets)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(request)))
                .andExpect(status().is(200))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.isCorrect").value("true"));
    }

    @Test
    void checkIncorrectBrackets() throws Exception {
        CheckBracketsRequest request = new CheckBracketsRequest("Это некорректный случай ! :)");
        perform(post(EndPoint.api + EndPoint.checkBrackets)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(request)))
                .andExpect(status().is(200))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.isCorrect").value("false"));
    }
}
