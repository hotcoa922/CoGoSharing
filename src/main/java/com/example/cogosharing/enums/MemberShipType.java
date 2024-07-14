package com.example.cogosharing.enums;


import lombok.Getter;

@Getter
public enum MemberShipType {
    Cop("커플"),
    Gop("그룹");

    private final String msg;

    MemberShipType(String msg) {this.msg = msg;}
}
