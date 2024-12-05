package com.example.register.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public record LoginDTO(String email, String password) {
}
