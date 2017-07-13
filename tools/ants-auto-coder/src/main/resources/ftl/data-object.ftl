package ${dataObject.packageName};
<#list dataObject.imports as import>
import ${import};
</#list>

/**
* @Description: ${(table.comment)!'TODO'}
* @author autoCoder
* @date 2017年5月3日 下午5:43:15 
*/
public class ${dataObject.name} extends ${dataObject.baseObject.name}{
<#list dataObject.fields as field>
	/**
	 *${(field.comment)!''}
	*/
	private ${(field.type)!''} ${(field.name)!''};
</#list>

<#list dataObject.fields as field>
	
	public void set${field.firstCamelName}(${field.type} ${field.name}){
		this.${field.name} = ${field.name};
	}
	
	public ${field.type} get${field.firstCamelName}(){
		return ${field.name};
	}
</#list>
}