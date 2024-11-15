package consumption.power.global.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "TB_EP_CLIENTE")
@EntityListeners(AuditingEntityListener.class)
public class Cliente {

    @Id
    @GeneratedValue
    @Column(name = "ID_CLIENTE")
    private Long id;

    @Size(max = 100, min = 10)
    @NotBlank(message = "Nome é obrigatório")
    @Column(name = "NM_CLIENTE", length = 100, nullable = false)
    private String nome;

    @Size(max = 200, min = 10)
    @NotBlank(message = "Endereço é obrigatório")
    @Column(name = "EN_CLIENTE", length = 200, nullable = false)
    private String endereco;

    @Size(max = 100, min = 10)
    @NotBlank(message = "Email é obrigatório")
    @Column(name = "EMAIL_CLIENTE", length = 100, nullable = false)
    private String email;

    @Size(max = 15, min = 5)
    @NotBlank(message = "Telefone é obrigatório")
    @Column(name = "NR_TELEFONE", length = 15, nullable = false)
    private String telefone;
}
