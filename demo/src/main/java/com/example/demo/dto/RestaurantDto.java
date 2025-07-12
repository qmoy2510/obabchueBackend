package com.example.demo.dto;


import java.util.List;
import java.util.Map;

public class RestaurantDto {
    // Restaurant.java (최상위 객체)
    public class Restaurant {
        private String placeId;
        private String restaurantName;
        private String category;
        private String address;
        private String phoneNumber;
        private double overallRating; // double 또는 String으로 파싱 후 변환
        private Location location;
        private List<MenuItem> menuItems;
        private Map<String, Integer> reviewsByStar; // JSON에선 비어있지만, 향후 추가될 수 있으므로 Map<String, Integer>로
        private String kakaoMapUrl;
        private String crawledAt;
        private String dataVersion;

        // Getters and Setters
    }

    // Location.java
    public class Location {
        private double latitude; // String으로 파싱 후 double로 변환
        private double longitude; // String으로 파싱 후 double로 변환

        // Getters and Setters
    }

    // MenuItem.java
    public class MenuItem {
        private String name;
        private String price; // 가격은 문자열 형태이므로 String으로 유지하거나, 정수형으로 변환 (e.g., "13,000원" -> 13000)

        // Getters and Setters
    }
}
