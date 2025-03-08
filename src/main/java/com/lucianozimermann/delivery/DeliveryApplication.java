package com.lucianozimermann.delivery;

import com.lucianozimermann.delivery.entities.Order;
import com.lucianozimermann.delivery.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class DeliveryApplication implements CommandLineRunner
{
    @Autowired
    private OrderService orderService;

    public static void main( String[] args )
    {
        SpringApplication.run( DeliveryApplication.class, args );
    }

    @Override
    public void run( String... args ) throws Exception
    {
        while ( true )
        {
            Locale.setDefault( Locale.US );
            Scanner sc = new Scanner( System.in );

            int code = sc.nextInt();
            double basic = sc.nextDouble();
            double discount = sc.nextDouble();

            Order order = new Order( code, basic, discount );

            System.out.println( "Pedido código " + order.getCode() );
            System.out.println( "Valor total: R$ " + String.format( "%.2f", orderService.total( order ) ) );
        }
    }
}
