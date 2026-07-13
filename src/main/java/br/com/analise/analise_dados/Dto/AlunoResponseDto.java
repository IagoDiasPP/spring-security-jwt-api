package br.com.analise.analise_dados.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlunoResponseDto {

    private Integer id;
    private String name;
    private String email;
    private LocalDate dayOfBirth;
}
