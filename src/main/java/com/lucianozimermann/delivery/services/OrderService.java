package com.lucianozimermann.delivery.services;

import com.lucianozimermann.delivery.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService
{
    @Autowired
    private ShippingService shippingService;

    public double total( Order order )
    {
        double discountValue = 0.0;

        if ( order.getDiscount() > 0.0 )
        {
            discountValue = order.getDiscount() * order.getBasic() / 100;
        }

        return order.getBasic() - discountValue + shippingService.shipment( order );
    }
}
