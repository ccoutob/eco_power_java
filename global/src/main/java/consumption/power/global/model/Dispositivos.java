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
@Table(name = "TB_EP_DISPOSITIVOS")
@EntityListeners(AuditingEntityListener.class)
public class Dispositivos {

    @Id
    @GeneratedValue
    @Column(name = "ID_DISPOSITVO")
    private Long id;

    @Size(max = 100, min = 10)
    @NotBlank(message = "Nome do dispositivo é obrigatório")
    @Column(name = "NM_DISPOSITIVO", length = 100, nullable = false)
    private String nomeDispositivo;

    @Size(max = 50, min = 10)
    @NotBlank(message = "Descricao é obrigatório")
    @Column(name = "TP_DISPOSITIVO", length = 50, nullable = false)
    private String tipoDispositivo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;
}
