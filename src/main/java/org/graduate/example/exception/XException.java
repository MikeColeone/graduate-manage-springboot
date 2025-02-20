package org.graduate.example.exception;
import lombok.*;
import org.graduate.example.dto.Code;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class XException extends RuntimeException{
    private Code code;
    private int codeN;
    private String message;
}
