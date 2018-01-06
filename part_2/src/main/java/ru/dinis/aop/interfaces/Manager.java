package ru.dinis.aop.interfaces;

import java.util.Map;
import java.util.Set;

/**
 * Create by dinis of 06.01.18.
 */
public interface Manager {

    Set<String> getExtensionList(String folder);

    Map<String, Integer> getExtensionCount(String folder);
}
