package com.onetoone.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class InstructorDetailDTO {
    private Integer id;
    @NotBlank(message = "{InstructorDetailDTO.youtubeChannel}")
    private String youtubeChannel;
    @NotBlank(message = "{InstructorDetailDTO.hobby}")
    private String hobby;

    public InstructorDetailDTO(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }
}
