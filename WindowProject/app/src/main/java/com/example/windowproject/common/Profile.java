package com.example.windowproject.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Profile {
    private static String G6 = "192.168.43.250";
    private static String IP = "172.30.1.14";
    private static String AWS = "ec2-15-164-143-254.ap-northeast-2.compute.amazonaws.com";
    public static String BASE_URL = "http://" + IP + ":8080";
}
