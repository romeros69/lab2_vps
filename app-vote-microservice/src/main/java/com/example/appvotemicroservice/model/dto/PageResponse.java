package com.example.appvotemicroservice.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@Builder(builderMethodName = "hiddenBuilder")
public class PageResponse {
    private Collection<?> items;
    private Boolean hasMore;

    public static PageResponseBuilder builder(Collection<?> items) {
        return PageResponse.hiddenBuilder()
                .items(items);
    }
}
