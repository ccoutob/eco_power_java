package consumption.power.global.model;

import java.time.LocalDate;

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
@Table(name = "TB_EP_CONSUMO")
@EntityListeners(AuditingEntityListener.class)
public class ConsumoEnergia {

    @Id
    @GeneratedValue
    @Column(name = "ID_CONSUMO")
    private Long id;

    @Column(name = "DT_CONSUMO")
    private LocalDate dataConsumo;

    @Column(name = "QT_KW", nullable = false)
    private Double quantidadeKW;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;
}
