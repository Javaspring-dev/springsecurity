package com.example.register.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public record LoginResponse(String message, boolean status) {
}
