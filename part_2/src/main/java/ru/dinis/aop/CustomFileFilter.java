package ru.dinis.aop;


import org.springframework.stereotype.Component;

import java.io.File;

import java.io.FilenameFilter;

/**
 * Create by dinis of 05.01.18.
 */

public class CustomFileFilter implements FilenameFilter {

    private String ext;

    public CustomFileFilter(String ext) {
        this.ext = ext;
    }

    public boolean accept(File dir, String name) {
        return name.toUpperCase().endsWith("." + ext.toUpperCase());
    }
}
