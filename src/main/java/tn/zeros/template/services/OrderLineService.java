package tn.zeros.template.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.zeros.template.entities.OrderLine;
import tn.zeros.template.repositories.OrderLineRepository;
import tn.zeros.template.services.IServices.IOrderLineService;

import java.util.List;


@RequiredArgsConstructor
@Service
@Slf4j
public class OrderLineService implements IOrderLineService {
    private final OrderLineRepository orderLineRepository ;
    @Override
    public OrderLine addOrderLine(OrderLine orderLine) {
        return orderLineRepository.save(orderLine);
    }

    @Override
    public void removeOrderLine(Long id) {
        orderLineRepository.deleteById(id);
    }

    @Override
    public List<OrderLine> retrieveAllOrderLines() {
        return orderLineRepository.findAll();
    }

    @Override
    public OrderLine retrieveOrderLine(Long id) {
        return orderLineRepository.findById(id).get();
    }

    @Override
    public OrderLine modifyOrderLine(OrderLine orderLine) {
        return orderLineRepository.save(orderLine);
    }
}
