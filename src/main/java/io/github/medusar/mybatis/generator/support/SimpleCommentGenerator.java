package io.github.medusar.mybatis.generator.support;

import static org.mybatis.generator.internal.util.StringUtility.isTrue;

import java.util.Properties;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.InnerEnum;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.XmlElement;

public class SimpleCommentGenerator implements CommentGenerator {

    public static final String CONFIG_FIELD_ADD_DEFAULT_VALUE = "addDefaultValue";

    /**
     * The properties.
     */
    private final Properties properties;

    private boolean addDefaultValue = false;

    public SimpleCommentGenerator() {
        this.properties = new Properties();
    }

    public void addConfigurationProperties(Properties properties) {
        this.properties.putAll(properties);
        addDefaultValue = isTrue(properties.getProperty(CONFIG_FIELD_ADD_DEFAULT_VALUE));
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable,
                                IntrospectedColumn introspectedColumn) {
        field.addJavaDocLine("/**"); //$NON-NLS-1$
        field.addJavaDocLine(" * " + introspectedColumn.getRemarks());
        if (addDefaultValue) {
            field.addJavaDocLine(" * default value in database:'" + introspectedColumn.getDefaultValue() + "'");
        }
        field.addJavaDocLine(" */");
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {

    }

    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine(" * " + introspectedTable.getRemarks());
        topLevelClass.addJavaDocLine(" */");
    }

    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
        innerClass.addJavaDocLine("/**");
        innerClass.addJavaDocLine(" * " + introspectedTable.getRemarks());
        innerClass.addJavaDocLine(" */");
    }

    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
        innerClass.addJavaDocLine("/**");
        innerClass.addJavaDocLine(" * " + introspectedTable.getRemarks());
        innerClass.addJavaDocLine(" */");
    }

    @Override
    public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {

    }

    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable,
                                 IntrospectedColumn introspectedColumn) {
    }

    @Override
    public void addSetterComment(Method method, IntrospectedTable introspectedTable,
                                 IntrospectedColumn introspectedColumn) {
    }

    @Override
    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {

    }

    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {

    }

    @Override
    public void addComment(XmlElement xmlElement) {
    }

    @Override
    public void addRootComment(XmlElement rootElement) {

    }

}
