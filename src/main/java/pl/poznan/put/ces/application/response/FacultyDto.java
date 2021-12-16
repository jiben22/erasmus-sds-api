package pl.poznan.put.ces.application.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FacultyDto {

    private String id;
    private String name;
    private String imageUrl;
}
