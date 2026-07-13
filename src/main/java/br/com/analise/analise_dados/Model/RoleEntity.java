package br.com.analise.analise_dados.Model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name ="roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class RoleEntity implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }
}
