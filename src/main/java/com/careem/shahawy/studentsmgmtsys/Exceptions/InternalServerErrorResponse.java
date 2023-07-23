package com.careem.shahawy.studentsmgmtsys.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InternalServerErrorResponse {
    private String message;
}
