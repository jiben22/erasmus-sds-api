package pl.poznan.put.ces.application.response;

import lombok.Builder;
import lombok.Data;
import pl.poznan.put.ces.domain.entity.enums.Diploma;
import pl.poznan.put.ces.domain.entity.enums.Semester;

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
}
