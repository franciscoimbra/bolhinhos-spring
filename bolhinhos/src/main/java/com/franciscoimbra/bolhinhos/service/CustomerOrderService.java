package com.franciscoimbra.bolhinhos.service;

import com.franciscoimbra.bolhinhos.dto.CustomerOrderDTO;
import com.franciscoimbra.bolhinhos.mapper.CustomerOrderMapper;
import com.franciscoimbra.bolhinhos.model.CustomerOrder;
import com.franciscoimbra.bolhinhos.repository.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderService {
    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    @Autowired
    private CustomerOrderMapper customerOrderMapper;

    public CustomerOrderDTO save(CustomerOrderDTO customerOrderDTO) {
        return customerOrderMapper.customerOrderToCustomerOrderDTO(customerOrderRepository.save(customerOrderMapper.customerOrderDTOToCustomerOrder(customerOrderDTO)));
    }

    public List<CustomerOrderDTO> findAll() {
        return customerOrderMapper.customerOrdersToCustomerOrderDTOs(customerOrderRepository.findAll());
    }

    public CustomerOrderDTO findById(int id) {
        return customerOrderMapper.customerOrderToCustomerOrderDTO(customerOrderRepository.getReferenceById(id));
    }
    public void delete(int id) {
        customerOrderRepository.deleteById(id);
    }
}
