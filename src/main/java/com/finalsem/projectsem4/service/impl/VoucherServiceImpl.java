package com.finalsem.projectsem4.service.impl;

import com.finalsem.projectsem4.common.DateTimeUtil;
import com.finalsem.projectsem4.common.ResponseBuilder;
import com.finalsem.projectsem4.dto.VouchersDTO;
import com.finalsem.projectsem4.entity.Vouchers;
import com.finalsem.projectsem4.repository.VoucherRepository;
import com.finalsem.projectsem4.service.VoucherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ly Quoc Trong
 */
@Service
public class VoucherServiceImpl implements VoucherService {
    @Autowired
    private VoucherRepository voucherRepository;
    @Override
    public ResponseBuilder<List<VouchersDTO>> getAllVoucher() {
        List<Vouchers> vouchers = voucherRepository.findAll();
        List<VouchersDTO> voucherDTOs = vouchers.stream().map(voucher -> {
            VouchersDTO vouchersDTO;
            ModelMapper modelMapper = new ModelMapper();
            vouchersDTO = modelMapper.map(voucher, VouchersDTO.class);
            vouchersDTO.setCreatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, voucher.getCreatedAt()));
            vouchersDTO.setUpdatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, voucher.getUpdatedAt()));
            return vouchersDTO;
        }).collect(java.util.stream.Collectors.toList());
        return new ResponseBuilder<>("00", "Success", voucherDTOs);
    }

    @Override
    public ResponseBuilder<VouchersDTO> getVoucherById(Long id) {
        Vouchers vouchers = voucherRepository.getReferenceById(id);
        VouchersDTO vouchersDTO;
        ModelMapper modelMapper = new ModelMapper();
        vouchersDTO = modelMapper.map(vouchers, VouchersDTO.class);
        vouchersDTO.setCreatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, vouchers.getCreatedAt()));
        vouchersDTO.setUpdatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, vouchers.getUpdatedAt()));
        return new ResponseBuilder<>("00", "Success", vouchersDTO);
    }

    @Override
    public ResponseBuilder<VouchersDTO> addVoucher(VouchersDTO dto) {
        try {
            Vouchers vouchers = new Vouchers();
            ModelMapper modelMapper = new ModelMapper();
            vouchers = modelMapper.map(dto, Vouchers.class);
            voucherRepository.save(vouchers);
            return new ResponseBuilder<>("00", "Success", dto);
        } catch (Exception e) {
            return new ResponseBuilder<>("99", "Error");
        }
    }

    @Override
    public ResponseBuilder<VouchersDTO> updateVoucher(Long id, VouchersDTO dto) {
        try {
            Vouchers vouchers = voucherRepository.getReferenceById(id);
            ModelMapper modelMapper = new ModelMapper();
            vouchers = modelMapper.map(dto, Vouchers.class);
            voucherRepository.save(vouchers);
            return new ResponseBuilder<>("00", "Success", dto);
        } catch (Exception e) {
            return new ResponseBuilder<>("99", "Error");
        }
    }

    @Override
    public ResponseBuilder deleteVoucher(Long id) {
        try {
            voucherRepository.deleteById(id);
            return new ResponseBuilder<>("00", "Success");
        } catch (Exception e) {
            return new ResponseBuilder<>("99", "Error");
        }
    }
}
