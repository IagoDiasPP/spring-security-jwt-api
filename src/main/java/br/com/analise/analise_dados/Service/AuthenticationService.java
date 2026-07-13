package br.com.analise.analise_dados.Service;

import br.com.analise.analise_dados.Dto.LoginRequestDto;
import br.com.analise.analise_dados.Dto.RegisterRequestDto;
import br.com.analise.analise_dados.Dto.TokenResponseDTO;
import br.com.analise.analise_dados.Exception.BadRequestException;
import br.com.analise.analise_dados.Model.Aluno;
import br.com.analise.analise_dados.Model.RoleEntity;
import br.com.analise.analise_dados.Repository.AlunoRepository;
import br.com.analise.analise_dados.Repository.RolesRepository;
import br.com.analise.analise_dados.config.TokenProvider;
import br.com.analise.analise_dados.enums.RoleTypeEnum;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AlunoRepository alunoRepository;
    private final RolesRepository rolesRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenProvider tokenProvider;

    @Value("${jwt.expiration}")
    private long expirationTime;

    @Transactional
    public Aluno register(RegisterRequestDto dto) {

        if (alunoRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new BadRequestException("Aluno já cadastrado com este email");
        }

        RoleEntity role = rolesRepository.findByName(RoleTypeEnum.ROLE_ALUNO.name())
                .orElseGet(() -> rolesRepository.save(
                        RoleEntity.builder()
                                .name(RoleTypeEnum.ROLE_ALUNO.name())
                                .build()
                ));

        return alunoRepository.save(
                Aluno.builder()
                        .name(dto.getName())
                        .email(dto.getEmail())
                        .roles(Set.of(role))
                        .password(passwordEncoder.encode(dto.getPassword()))
                        .dayOfBirth(dto.getDayOfBirth())
                        .build()
        );
    }

    public TokenResponseDTO login(LoginRequestDto dto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getEmail(),
                        dto.getPassword()
                )
        );

        String token = tokenProvider.generateToken(authentication);

        return new TokenResponseDTO(token, expirationTime);
    }
}
