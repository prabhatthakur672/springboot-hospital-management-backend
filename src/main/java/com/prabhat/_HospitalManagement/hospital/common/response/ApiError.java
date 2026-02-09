package com.prabhat._HospitalManagement.hospital.common.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApiError {

    private String code;
    private String details;
}
