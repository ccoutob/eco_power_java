package consumption.power.global.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "TB_EP_RELATORIOS")
@EntityListeners(AuditingEntityListener.class)
public class Relatorios {

    @Id
    @GeneratedValue
    @Column(name = "ID_RELATORIO")
    private Long id;

    @Column(name = "DT_RELATORIO", nullable = false)
    private LocalDate dataRelatorio;

    @Size(max = 500, min = 10)
    @NotBlank(message = "Descricao é obrigatório")
    @Column(name = "EP_DESCRICAO", length = 500, nullable = false)
    private String descricao;

    @NotNull(message = "Nome é obrigatório")
    @Column(name = "EP_EMISSAO", nullable = false)
    private Double emissaoCO2;

    @NotNull(message = "Economia de energia é obrigatório")
    @Column(name = "EP_ECONOMIA", nullable = false)
    private Double economiaEnergia;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;
}
