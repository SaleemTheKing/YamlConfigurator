package com.Saleem.YamlConfigurator;

import java.io.File;
import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        System.out.println("Started");
        File dir = new File("./config");
        if (!dir.exists()) {
            dir.mkdir();
        }

        YamlFile file = new YamlFile("test");
        file.setBool("bool", false);
        file.setFloat("float", 2.2f);
        file.setList("list", Arrays.stream(new String[]{"test1", "test2"}).toList());
        file.setInt("int", 69);
        file.setInt("age", 100);
        file.save();

        YamlFile file2 = YamlFile.load("test");
        System.out.println(file2.getBool("bool"));
    }
}
