package website.wesports.Business;
/*
 * Class: CIST 2931 : Advanced Systems Project Management
 * Term: Spring 2024
 * Instructor: Ron Enz
 * Description: Order Repository List
 * Authors: Heather Papp
 *
 *
 *
 */
import java.util.List;
import website.wesports.Business.Orders;
/**
 *   OrdersRepository for Orders
 * @author Heather Papp
 */
public interface OrdersRepository {
    List<Orders> findAll();
    void insert(Orders orders);
}
