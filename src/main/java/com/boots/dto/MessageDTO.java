package com.boots.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;

@JsonSerialize

@AllArgsConstructor
@Data
public class MessageDTO {

    String message;
}
