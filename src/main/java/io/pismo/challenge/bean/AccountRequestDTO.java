package io.pismo.challenge.bean;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountRequestDTO {

    @NotNull(message = "Document number is required")
    @Pattern(regexp = "\\d{11}", message = "Document number must be 11 digits")
    private String documentNumber;

}
