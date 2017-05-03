package ${queryObject.packageName};
<#list queryObject.imports as import>
import ${import};
</#list>

/**
 * 
 * @author autoCreate
 * @version $Id: ${queryObject.name}.java ${queryObject.createTime}
 */
public class ${queryObject.name} extends ${queryObject.baseObject.name}{
<#list queryObject.fieldsFilterCommon as field>
	/**
	 *${(field.annotation)!''}
	*/
	private ${(field.type)!''} ${(field.name)!''};
</#list>

<#list queryObject.fieldsFilterCommon as field>
	
	public void set${field.firstCamelName}(${field.type} ${field.name}){
		this.${field.name} = ${field.name};
	}
	
	public ${field.type} get${field.firstCamelName}(){
		return ${field.name};
	}
</#list>
}