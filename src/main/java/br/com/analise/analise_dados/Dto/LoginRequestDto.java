package br.com.analise.analise_dados.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
