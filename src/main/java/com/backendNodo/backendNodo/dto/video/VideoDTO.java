package com.backendNodo.backendNodo.dto.video;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoDTO {
    private UUID id;
    private String description;
    private String urlVideo;
    private UUID contentId;
}
