package pl.poznan.put.ces.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.poznan.put.ces.domain.entity.Testimonial;
import pl.poznan.put.ces.infrastructure.TestimonialRepository;

/**
 * Testimonial service
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class DomainTestimonialService implements TestimonialService {

    private final TestimonialRepository repository;

    @Override
    public Testimonial addTestimonial(Testimonial testimonial) {
        return repository.saveAndFlush(testimonial);
    }
}
