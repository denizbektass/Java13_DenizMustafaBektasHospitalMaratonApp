package com.dennis.mapper;

import com.dennis.dto.response.GetDoctorInfoResponseDto;
import com.dennis.entity.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GetDoctorInfoResponseDtoMapper {
    GetDoctorInfoResponseDtoMapper INSTANCE = Mappers.getMapper(GetDoctorInfoResponseDtoMapper.class);
    GetDoctorInfoResponseDto fromDoctor(final Doctor doctor);
}
