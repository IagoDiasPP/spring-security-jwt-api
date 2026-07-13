package br.com.analise.analise_dados.Controller;
import br.com.analise.analise_dados.Dto.AlunoCreateDto;
import br.com.analise.analise_dados.Dto.AlunoResponseDto;
import br.com.analise.analise_dados.Dto.AlunoUpdateDto;
import br.com.analise.analise_dados.Service.AlunoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
@AllArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AlunoResponseDto> create(
            @Valid @RequestBody AlunoCreateDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(alunoService.create(dto));
    }

    @PreAuthorize("#id == authentication.principal.id or hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponseDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(alunoService.findById(id));
    }

    @PreAuthorize("#id == authentication.principal.id or hasRole('ADMIN')")
    @GetMapping("/search")
    public ResponseEntity<AlunoResponseDto> findByName(@RequestParam String name) {
        return ResponseEntity.ok(alunoService.findByName(name));
    }

    @PreAuthorize("#id == authentication.principal.id or hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<AlunoResponseDto> update(
            @PathVariable Integer id,
            @RequestBody AlunoUpdateDto dto) {
        return ResponseEntity.ok(alunoService.update(id, dto));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        alunoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
