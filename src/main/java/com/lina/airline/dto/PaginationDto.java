package com.lina.airline.dto;

import lombok.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaginationDto<T> {
    private List<T> usersData;             // List of user data
    private PaginationInfo pagination;  // Pagination information
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PaginationInfo {
        private int page;
        private int size;
        private int totalPages;
        private long totalUsers;
    }
}
