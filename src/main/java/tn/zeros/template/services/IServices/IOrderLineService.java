package tn.zeros.template.services.IServices;

import tn.zeros.template.entities.OrderLine;

import java.util.List;

public interface IOrderLineService {
    OrderLine addOrderLine (OrderLine orderLine);

    public void removeOrderLine(Long id);
    public List<OrderLine> retrieveAllOrderLines();

    public OrderLine retrieveOrderLine(Long id);

    public OrderLine modifyOrderLine(OrderLine orderLine);
}
