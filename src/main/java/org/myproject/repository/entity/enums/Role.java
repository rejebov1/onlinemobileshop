package org.myproject.repository.entity.enums;

public enum Role {
    ADMIN {
        public String toString() {
            return "Administrator";
        }
    },
    USER {
        public String toString() {
            return "User";
        }
    }
}
