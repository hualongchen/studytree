package com.lemon.chen.service;


import org.springframework.stereotype.Service;

@Service
public class SerurityMethodServiceImpl implements SerurityMethodService{
    @Override
    public int findNum() {

        System.out.println("every one can take it");
        return 0;
    }

    @Override
    public int update() {

        System.out.println(" only admin can take it ");
        return 0;
    }

    @Override
    public int del() {

        System.out.println("must dba and admin can take it");
        return 0;
    }

    @Override
    public int one() {
        System.out.println("返回的类型等于传过来的类型，也就是类型一一致");
        return 0;
    }

    @Override
    public int two() {

        System.out.println("must admin can take it two");
        return 0;
    }

    @Override
    public int three() {

        System.out.println("must admin and dba can take it ");
        return 0;
    }
}
