package com.backendNodo.backendNodo.dto.video;

import com.backendNodo.backendNodo.model.User;
import com.backendNodo.backendNodo.model.Video;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VideoMapper {
    @Mappings({
            @Mapping(target = "content.id", source = "contentId")
    })
    Video toModel(VideoRequest videoRequest);
    @Mappings({
            @Mapping(target = "contentId", source = "content.id")
    })
    VideoDTO toDto(Video video);
}
