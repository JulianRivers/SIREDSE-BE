package BackendSiadseUfps.siadse.dto;


import lombok.Data;

@Data
public class ResponseDTO {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
