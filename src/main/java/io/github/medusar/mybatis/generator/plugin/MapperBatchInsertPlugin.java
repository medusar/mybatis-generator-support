package io.github.medusar.mybatis.generator.plugin;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.Context;

import java.util.List;

public class MapperBatchInsertPlugin extends PluginAdapter {

    private static final String batchMethodName = "insertBatch";

    private Context context;

    @Override
    public void setContext(Context context) {
        this.context = context;
    }


    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        //JavaMapperGenerator
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(null); //void
        method.setName(batchMethodName);

        FullyQualifiedJavaType parameterType = FullyQualifiedJavaType.getNewListInstance();
        FullyQualifiedJavaType listType;
        if (introspectedTable.getRules().generateRecordWithBLOBsClass()) {
            listType = new FullyQualifiedJavaType(introspectedTable
                    .getRecordWithBLOBsType());
        } else {
            // the blob fields must be rolled up into the base class
            listType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
        }
        parameterType.addTypeArgument(listType);
        Parameter parameter = new Parameter(parameterType, "list", "@Param(\"list\")");
        method.addParameter(parameter); //$NON-NLS-1$

        interfaze.addMethod(method);
        return true;
    }

    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        //参考 XMLMapperGenerator

        //<mapper>
        XmlElement rootElement = document.getRootElement();

        InsertBatchElementGenerator elementGenerator = new InsertBatchElementGenerator(batchMethodName);
        elementGenerator.setContext(context);
        elementGenerator.setIntrospectedTable(introspectedTable);
//        elementGenerator.setProgressCallback(progressCallback);
//        elementGenerator.setWarnings(warnings);
        elementGenerator.addElements(rootElement);

        return true;
    }
}
