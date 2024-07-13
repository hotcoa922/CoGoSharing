package com.example.cogosharing.enums;


import lombok.Getter;

@Getter
public enum MemberType {
    Cop("커플"),
    Gop("그룹");

    private final String msg;

    MemberType(String msg) {this.msg = msg;}
}
