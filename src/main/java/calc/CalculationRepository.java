package calc;

import org.springframework.data.jpa.repository.JpaRepository;

interface CalculationRepository extends JpaRepository<Calculation, Long>{
}
