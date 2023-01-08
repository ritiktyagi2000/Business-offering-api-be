package com.springboot.offeringapi.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorModel {
private String message;
private String code;

}
