package com.franciscoimbra.bolhinhos.mapper;

import com.franciscoimbra.bolhinhos.dto.CustomerOrderDTO;
import com.franciscoimbra.bolhinhos.model.CustomerOrder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerOrderMapper {
    CustomerOrderDTO customerOrderToCustomerOrderDTO(CustomerOrder customerOrder);
    CustomerOrder customerOrderDTOToCustomerOrder(CustomerOrderDTO customerOrderDTO);
    List<CustomerOrderDTO> customerOrdersToCustomerOrderDTOs(List<CustomerOrder> customerOrders);
    List<CustomerOrder> customerOrderDTOsToCustomerOrders(List<CustomerOrderDTO> customerOrderDTOs);
}
