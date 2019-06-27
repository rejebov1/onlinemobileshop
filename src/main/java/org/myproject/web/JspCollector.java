package org.myproject.web;

public class JspCollector {
    private static final String PREFIX = "/WEB-INF/jsp/";
    private static final String SUFFIX = ".jsp";

    public static String getPath(String pageName){
        return PREFIX + pageName + SUFFIX;
    }
}
