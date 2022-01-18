package pl.poznan.put.ces.application.response;

import lombok.Builder;
import lombok.Data;
import pl.poznan.put.ces.domain.entity.Coordinator;
import pl.poznan.put.ces.domain.entity.Testimonial;
import pl.poznan.put.ces.domain.entity.enums.Diploma;
import pl.poznan.put.ces.domain.entity.enums.Semester;

import java.util.Set;

@Builder
@Data
public class CourseDto {

    private String id;
    private String title;
    private String description;
    private Integer ects;
    private Integer hours;
    private Semester semester;
    private String descriptionCardUrl;
    private Diploma diploma;
    private Set<Coordinator> coordinators;
    private Set<Testimonial> testimonials;
}
