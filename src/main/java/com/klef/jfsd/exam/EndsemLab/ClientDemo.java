package com.klef.jfsd.exam.EndsemLab;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Insert records
        Device device = new Device();
        device.setBrand("Generic Brand");
        device.setModel("Generic Model");
        device.setPrice(500.0);

        Smartphone smartphone = new Smartphone();
        smartphone.setBrand("Apple");
        smartphone.setModel("iPhone 14");
        smartphone.setPrice(1200.0);
        smartphone.setOperatingSystem("iOS");
        smartphone.setCameraResolution("48MP");

        Tablet tablet = new Tablet();
        tablet.setBrand("Samsung");
        tablet.setModel("Galaxy Tab S8");
        tablet.setPrice(800.0);
        tablet.setScreenSize("11 inches");
        tablet.setBatteryLife("10 hours");

        // Save records
        session.save(device);
        session.save(smartphone);
        session.save(tablet);

        transaction.commit();
        session.close();
        sessionFactory.close();

        System.out.println("Records inserted successfully.");
    }
}
