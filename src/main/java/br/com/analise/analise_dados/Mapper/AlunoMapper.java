package br.com.analise.analise_dados.Mapper;

import br.com.analise.analise_dados.Dto.AlunoCreateDto;
import br.com.analise.analise_dados.Dto.AlunoResponseDto;
import br.com.analise.analise_dados.Model.Aluno;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlunoMapper {

    Aluno toAluno(AlunoCreateDto dto);

    AlunoResponseDto toResponseDto(Aluno aluno);
}
