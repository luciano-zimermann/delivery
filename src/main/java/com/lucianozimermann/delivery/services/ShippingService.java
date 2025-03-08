package com.lucianozimermann.delivery.services;

import com.lucianozimermann.delivery.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService
{
    public double shipment( Order order )
    {
        double shipment = 0.0;
        double basic = order.getBasic();

        if ( basic < 100.0 )
        {
            shipment = 20.0;
        }

        else if ( basic >= 100.0 && basic <= 200.00 )
        {
            shipment = 12.0;
        }

        return shipment;
    }
}
