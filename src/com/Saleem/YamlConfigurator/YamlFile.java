package com.Saleem.YamlConfigurator;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class YamlFile {

    private HashMap<String, Object> properties = new HashMap<>();
    private String fileName = "";

    public YamlFile() {
    }

    public YamlFile(String fileName) {
        this.fileName = fileName;
    }

    public void setValue(String key, Object value) {
        properties.putIfAbsent(key, value);
    }

    public Object getValue(String key) {
        return properties.get(key);
    }

    public void setBool(String key, Boolean value) {
        properties.putIfAbsent(key, value);
    }

    public Boolean getBool(String key) {
        return (Boolean) properties.get(key);
    }

    public void setString(String key, String value) {
        properties.putIfAbsent(key, value);
    }

    public String getString(String key) {
        return (String) properties.get(key);
    }

    public void setInt(String key, Integer value) {
        properties.putIfAbsent(key, value);
    }

    public Integer getInt(String key) {
        return (Integer) properties.get(key);
    }

    public void setFloat(String key, Float value) {
        properties.putIfAbsent(key, value);
    }

    public Float getFloat(String key) {
        return (Float) properties.get(key);
    }

    public void setList(String key, List value) {
        properties.putIfAbsent(key, value);
    }

    public List getList(String key) {
        return (List) properties.get(key);
    }

    public void save() {
        if (this.fileName.equals("")) {
            System.out.println("ERROR: No file name provided");
            return;
        }

        try {
            Yaml yaml = new Yaml();
            FileWriter writer = new FileWriter(String.format("./config/%s.yml", fileName));
            yaml.dump(this, writer);
        } catch (Exception e) {
            System.out.println("ERROR: Something went wrong trying to save the file");
            System.out.println(e);
        }
    }

    public void save(String fileName) {
        try {
            Yaml yaml = new Yaml();
            FileWriter writer = new FileWriter(String.format("./config/%s.yml", fileName));
            yaml.dump(this, writer);
        } catch (Exception e) {
            System.out.println("ERROR: Something went wrong trying to save the file");
            System.out.println(e);
        }
    }

    public static YamlFile load(String fileName) {
        try {
            InputStream inputStream = new FileInputStream(String.format("config/%s.yml", fileName));
            Yaml yaml = new Yaml(new Constructor(YamlFile.class));
            YamlFile file = yaml.load(inputStream);
            file.fileName = fileName;
            return file;
        } catch (Exception e) {
            System.out.println("ERROR: File not found");
        }

        return null;
    }
}
