package br.com.analise.analise_dados.Service;


import br.com.analise.analise_dados.Dto.AlunoResponseDto;
import br.com.analise.analise_dados.Exception.BadRequestException;
import br.com.analise.analise_dados.Exception.ResourceNotFoundException;
import br.com.analise.analise_dados.Mapper.AlunoMapper;
import br.com.analise.analise_dados.Dto.AlunoCreateDto;
import br.com.analise.analise_dados.Dto.AlunoUpdateDto;
import br.com.analise.analise_dados.Model.Aluno;
import br.com.analise.analise_dados.Repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final AlunoMapper alunoMapper;

    public AlunoResponseDto create(AlunoCreateDto dto) {

        if (alunoRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new BadRequestException("Aluno já cadastrado com este email");
        }

        Aluno aluno = alunoMapper.toAluno(dto);

        Aluno saved = alunoRepository.save(aluno);

        return alunoMapper.toResponseDto(saved);
    }

    public AlunoResponseDto findById(Integer id) {

        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado"));

        return alunoMapper.toResponseDto(aluno);
    }

    public AlunoResponseDto findByName(String name) {

        Aluno aluno = alunoRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado"));

        return alunoMapper.toResponseDto(aluno);
    }

    public AlunoResponseDto update(Integer id, AlunoUpdateDto dto) {

        Aluno aluno = findEntityById(id);

        validateEmail(id, dto.getEmail());

        aluno.setName(dto.getName());
        aluno.setEmail(dto.getEmail());
        aluno.setDayOfBirth(dto.getDayOfBirth());

        return alunoMapper.toResponseDto(alunoRepository.save(aluno));
    }

    public void delete(Integer id) {
        alunoRepository.delete(findEntityById(id));
    }


    private Aluno findEntityById(Integer id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado"));
    }

    private void validateEmail(Integer id, String email) {

        Optional<Aluno> aluno = alunoRepository.findByEmail(email);

        if (aluno.isPresent() && !aluno.get().getId().equals(id)) {
            throw new BadRequestException("Aluno já cadastrado com este email");
        }
    }
}
