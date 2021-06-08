package io.github.medusar.mybatis.generator.plugin;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

import java.util.List;

public class ExampleRenamePlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public void initialized(IntrospectedTable introspectedTable) {
        //override IntrospectedTable.calculateXmlAttributes() to set new method patterns
        introspectedTable.setCountByExampleStatementId("countByCriteria"); //$NON-NLS-1$
        introspectedTable.setDeleteByExampleStatementId("deleteByCriteria"); //$NON-NLS-1$
        introspectedTable.setSelectByExampleStatementId("selectByCriteria"); //$NON-NLS-1$
        introspectedTable.setSelectByExampleWithBLOBsStatementId("selectByCriteriaWithBLOBs"); //$NON-NLS-1$
        introspectedTable.setUpdateByExampleStatementId("updateByCriteria"); //$NON-NLS-1$
        introspectedTable.setUpdateByExampleSelectiveStatementId("updateByCriteriaSelective"); //$NON-NLS-1$
        introspectedTable.setUpdateByExampleWithBLOBsStatementId("updateByCriteriaWithBLOBs"); //$NON-NLS-1$
        introspectedTable.setExampleWhereClauseId("Criteria_Where_Clause"); //$NON-NLS-1$
        introspectedTable.setMyBatis3UpdateByExampleWhereClauseId("Update_By_Criteria_Where_Clause"); //$NON-NLS-1$

        String exampleType = introspectedTable.getExampleType();
        if (exampleType.endsWith("Example")) {
            String newName = exampleType.replaceAll("Example$", "Criteria");
            introspectedTable.setExampleType(newName);
        }
    }
}
