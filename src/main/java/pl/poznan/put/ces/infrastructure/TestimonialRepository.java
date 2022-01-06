package pl.poznan.put.ces.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.poznan.put.ces.domain.entity.Testimonial;

/**
 * Testimonial repository
 */
@Repository
public interface TestimonialRepository extends JpaRepository<Testimonial, String> {

}
