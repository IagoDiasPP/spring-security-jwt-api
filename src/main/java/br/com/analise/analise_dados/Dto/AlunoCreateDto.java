package br.com.analise.analise_dados.Dto;
import br.com.analise.analise_dados.Enums.StatusAluno;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlunoCreateDto {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String name;

    @Past
    @NotNull
    private LocalDate dayOfBirth;
}
