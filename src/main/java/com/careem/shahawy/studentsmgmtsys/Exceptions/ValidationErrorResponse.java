package com.careem.shahawy.studentsmgmtsys.Exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class ValidationErrorResponse {

    private List<Violation> violations = new ArrayList<>();
}
