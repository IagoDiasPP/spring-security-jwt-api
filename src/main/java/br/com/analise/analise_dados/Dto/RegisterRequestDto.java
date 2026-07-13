package br.com.analise.analise_dados.Dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDto {

    @Email
    @NotBlank
    @Size(max = 255)
    private String email;

    @NotBlank
    @Size(min = 8, max = 100)
    private String password;

    @NotBlank
    @Size(max = 100)
    private String name;

    @Past
    @NotNull
    private LocalDate dayOfBirth;
}

