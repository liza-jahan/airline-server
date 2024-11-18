package com.lina.airline.dto.response;

import com.lina.airline.dto.PaginationDto;
import com.lina.airline.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private List<UserDTO> users;
    private PaginationDto pagination;
}
