package ru.dinis.aop.main;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.dinis.aop.FileManager;

/**
 * Create by dinis of 05.01.18.
 */
public class Start {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context2.xml");
        FileManager manager = (FileManager) context.getBean("fileManager");
        manager.getExtensionCount("/home/dinis/IdeaProjects/junior");
        manager.getExtensionList("/home/dinis/IdeaProjects/junior/chapter_002");
    }

}
