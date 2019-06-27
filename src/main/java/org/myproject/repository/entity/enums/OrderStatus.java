package org.myproject.repository.entity.enums;

public enum OrderStatus {
    NEW {
        @Override
        public String toString() {
            return "New Order";
        }
    },
    REVIEWING {
        @Override
        public String toString() {
            return "Preparation for delivery";
        }
    },
    IN_PROGRESS {
        @Override
        public String toString() {
            return "Delivery in process";
        }
    },
    DELIVERED {
        @Override
        public String toString() {
            return "Order Delivered";
        }
    }
}