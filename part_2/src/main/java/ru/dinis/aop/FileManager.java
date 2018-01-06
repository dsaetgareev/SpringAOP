package ru.dinis.aop;


import org.springframework.stereotype.Component;
import ru.dinis.aop.annotations.ShowResult;
import ru.dinis.aop.annotations.ShowTime;
import ru.dinis.aop.interfaces.Manager;

import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Create by dinis of 05.01.18.
 */
@Component
public class FileManager implements Manager {

    @Override

    public Set<String> getExtensionList(String folder) {
        File dir = new File(folder);

        Set<String> extList = new TreeSet<String>();

        for (String fileName : dir.list()) {
            File file = new File(dir.getAbsolutePath() + "/" + fileName);
            int i = fileName.lastIndexOf(".");
            if (file.isFile() && i != -1) {
                extList.add(fileName.substring(i + 1, fileName.length()).toLowerCase());
            }
        }
        return extList;
    }

    @Override

    public Map<String, Integer> getExtensionCount(String folder) {
        File dir = new File(folder);
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (String ext : getExtensionList(folder)) {
            FilenameFilter filter = new CustomFileFilter(ext);
            if (dir.listFiles(filter) != null) {
                map.put(ext, dir.listFiles(filter).length);
            }
        }
        return map;
    }

}
