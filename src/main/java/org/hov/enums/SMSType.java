package org.hov.enums;

public enum SMSType {
	USER_PHONE_VERIFICATION,
	USER_PHONE_CHANGE,
	USER_PASSWORD_CHANGE,
	USER_PAYMENT_PENDING,
	USER_PAYMENT_COMPLETED,
	BUYER_ORDER_PACKED,
	BUYER_ORDER_DISPATCHED,
	BUYER_ORDER_CANCELLED,		//when order is cancelled by seller or pickup/delivery person
	BUYER_ORDER_OUT_FOR_DELIVERY,
	BUYER_ORDER_DELIVERED,
	BUYER_ORDER_PICKUP,
	BUYER_ORDER_RETURNED,
	BUYER_ORDER_REFUNDED,
	SELLER_PROMOTION_ACTIVATED,
	SELLER_NEW_ORDER,
	SELLER_ORDER_CANCELLED,		//when user cancels
	SELLER_ORDER_PICKUP,
	SELLER_ORDER_RETURN,
	SELLER_PAYMENT_TRANSFERRED
}
