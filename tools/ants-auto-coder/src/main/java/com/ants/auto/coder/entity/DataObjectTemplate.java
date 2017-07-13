package com.ants.auto.coder.entity;

import java.util.Set;

/**
* @Description: DO 模版类
* @author smatiger
* @date 2017年7月12日 下午5:43:00 
*/
public class DataObjectTemplate {

    private String                   packageName;
    private Set<String>              imports;
    private String                   name;
    private Set<ObjectFieldTemplate> fields;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Set<String> getImports() {
        return imports;
    }

    public void setImports(Set<String> imports) {
        this.imports = imports;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ObjectFieldTemplate> getFields() {
        return fields;
    }

    public void setFields(Set<ObjectFieldTemplate> fields) {
        this.fields = fields;
    }

}
