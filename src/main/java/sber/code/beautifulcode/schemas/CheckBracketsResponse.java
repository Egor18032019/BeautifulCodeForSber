package sber.code.beautifulcode.schemas;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckBracketsResponse {
    @JsonProperty("isCorrect")
    private boolean isCorrect;
    public CheckBracketsResponse(boolean status) {
        this.isCorrect = status;
    }

    @Override
    public String toString() {
        return "CheckBracketsResponse{" +
                "isCorrect=" + isCorrect +
                '}';
    }
}
