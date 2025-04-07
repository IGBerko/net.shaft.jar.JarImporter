package net.shaft.jar;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.lang.reflect.Method;

public class JarHelper {
    public static void loadJar(File jarFile) throws Exception {
        if (!jarFile.exists()) {
            throw new IllegalArgumentException("JAR-файл не найден: " + jarFile.getPath());
        }

        URL jarUrl = jarFile.toURI().toURL();
        URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        Method method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
        method.setAccessible(true);
        method.invoke(classLoader, jarUrl);
    }
}
