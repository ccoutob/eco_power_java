package consumption.power.global.repository;

import consumption.power.global.model.ConsumoEnergia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumoRepository extends JpaRepository<ConsumoEnergia, Long> {
}
