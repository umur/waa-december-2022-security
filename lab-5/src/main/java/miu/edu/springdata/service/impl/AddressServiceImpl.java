package miu.edu.springdata.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.springdata.dto.AddressDto;
import miu.edu.springdata.dto.UserDto;
import miu.edu.springdata.entity.Address;
import miu.edu.springdata.entity.User;
import miu.edu.springdata.repository.AddressRepo;
import miu.edu.springdata.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepo addressRepo;
    private final ModelMapper mapper;

    public void save(Address address) {
        addressRepo.save(address);
    }

    @Override
    public List<AddressDto> findAll() {
        return getDtoList((List<Address>) addressRepo.findAll());
    }

    @Override
    public AddressDto findById(int id) {
        return
                getDto(addressRepo.findById(id).get());
    }

    @Override
    public void deleteById(int id) {
        addressRepo.deleteById(id);
    }


    private List<AddressDto> getDtoList(List<Address> addresses) {
        return addresses.stream().map(p -> {
            return getDto(p);
        }).toList();
    }

    private AddressDto getDto(Address address) {
        return mapper.map(address, AddressDto.class);
    }
}
