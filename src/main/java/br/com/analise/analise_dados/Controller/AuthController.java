package br.com.analise.analise_dados.Controller;

import br.com.analise.analise_dados.Dto.LoginRequestDto;
import br.com.analise.analise_dados.Dto.RegisterRequestDto;
import br.com.analise.analise_dados.Dto.TokenResponseDTO;
import br.com.analise.analise_dados.Service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestBody @Valid RegisterRequestDto dto) {

        authenticationService.register(dto);
        return ResponseEntity.ok("Usuário registrado com sucesso");
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDTO> login(
            @RequestBody @Valid LoginRequestDto dto) {

        return ResponseEntity.ok(authenticationService.login(dto));
    }
}
