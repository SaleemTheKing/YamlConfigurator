# Java YAML Configurator

This is a small library for configuring YAML files in Java.

## Prerequisites
* [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) or higher
* Create a folder named `config` in the root of the project

## How to (test) run 

The`Program.java` is a testing class. You can run the `main()` function to test the YAML library.

## How to use

**Creating a new file**

Create a new file by writing `new YamlFile()` or `new YamlFile(String fileName)`

There are several methods for getting and setting values:

**Getters**
* getBool(String key)
* getInt(String key)
* getFloat(String key)
* getString(String key)
* getList(String key)
* getValue(String key) (only for unknown values or for getting complicated data types)

**Setters**
* setBool(String key, Boolean value)
* setInt(String key, Integer value)
* setFloat(String key, Float value)
* setStringString key, String value()
* setList(String key, List value)
* setValue(String key, Object value) (only for unknown values or for lazy writing)

**Saving and loading**

You can save using:
* save()
* save(String fileName) useful for making copies

You can load an existing file by calling the static method `YamlFile.load(String fileName)`
