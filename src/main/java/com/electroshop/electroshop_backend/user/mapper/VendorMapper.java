package com.electroshop.electroshop_backend.user.mapper;

import com.electroshop.electroshop_backend.user.domain.Vendor;
import com.electroshop.electroshop_backend.user.dto.vendor.VendorDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VendorMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Vendor toVendor(VendorDto newVendor);

    List<VendorDto> toListOfVendorDto(List<Vendor> vendor);

    VendorDto toListOfVendorDto(Vendor vendor);
}
