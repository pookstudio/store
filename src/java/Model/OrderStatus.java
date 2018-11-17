/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Gail
 */
public class OrderStatus {
    
    public int StatusCancle = 99;
    
    public int StatusBasket = 0;
    public int StatusConfirmOrder = 1;
    public int StatusPayment = 2;
    public int StatusPaymentCancel = 3;
    public int StatusPay = 4;
    public int StatusPickup = 5;

    public OrderStatus() {
    }
    
}
