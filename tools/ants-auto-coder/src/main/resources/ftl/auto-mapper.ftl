<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${dataObject.namespace}">
    <resultMap id="resultMap" type="${dataObject.fullName}">
    	<#list dataObject.fields as field>
    		<result column="${field.columnName}" property="${field.name}"/>
		</#list>
    </resultMap>
    
    <sql id="queryColumns">
    	<#list dataObject.fields as field>
    		${field.columnName}<#if (field_has_next)>,</#if>  
		</#list>
    </sql>
   
     <sql id="queryParams">
    	<trim prefix=" WHERE " prefixOverrides="AND|OR">
    		<#list dataObject.fields as field>
    			<#if field.type == "Integer" || field.type == "Long">
    				<if test="${field.name} != null">
						AND ${field.columnName} = ${r"#{"}${field.name}${r"}"}
					</if>
				<#else>
					<if test="${field.name} != null and ${field.name} != ''">
						AND ${field.columnName} = ${r"#{"}${field.name}${r"}"}
					</if>
    			</#if>
			</#list>
    	</trim>
    </sql>
    
    <!--按id查询-->
    <select id="${mapperConfig.selectByIdEntry.idValue}" parameterType="java.lang.Long" resultMap="resultMap">
        SELECT
        <include refid="queryColumns"/>
        <![CDATA[
     		FROM ${dataObject.tableName} WHERE id = ${r"#{id}"}
    	]]>
    </select>
    
    <!--查询分页列表-->
    <select id="${mapperConfig.selectByQueryEntry.idValue}" resultMap="resultMap" parameterType="${queryObject.fullName}">
        SELECT
        <include refid="queryColumns"/>
        FROM ${dataObject.tableName}
        <include refid="queryParams"/>
        <if test="sorts != null and sorts.size > 0">
			order by
			<foreach collection="sorts" item="sort" separator=",">
				${r"${sort.columnName}"} ${r"${sort.sortType}"}
			</foreach>
		</if>
        <if test="page != null">
			limit ${r"#{page.offset}"},${r"#{page.size}"}
		</if>
    </select>
    
    <!--查询总数-->
    <select id="${mapperConfig.selectCountEntry.idValue}" parameterType="${queryObject.fullName}" resultType="java.lang.Integer">
    	select count(id) from ${dataObject.tableName}
    	<include refid="queryParams"/>
    </select>
    
    <!--添加-->
    <insert id="${mapperConfig.insertEntry.idValue}" parameterType="${dataObject.fullName}" useGeneratedKeys="true" keyProperty="id" keyColumn="id">
        INSERT INTO ${dataObject.tableName}
        (<#list dataObject.fields as field>
    		${field.columnName}<#if (field_has_next)>,</#if><#rt>
		</#list>)
		VALUES
		(<#list dataObject.fields as field>
    		${r"#{"}${field.name}${r"}"}<#if (field_has_next)>,</#if><#rt>
		</#list>)   
        <selectKey keyProperty="id" resultType="long" order="AFTER">  
            SELECT LAST_INSERT_ID()  
        </selectKey>  
    </insert>
    
    <!--更新-->
     <update id="${mapperConfig.updateEntry.idValue}" parameterType="${dataObject.fullName}">
        UPDATE ${dataObject.tableName} 
        <trim prefix="SET">
    	<#list dataObject.fields as field>
			<#if field.type == "Integer" || field.type == "Long">
			<if test="${field.name} != null">${field.columnName}=${r"#{"}${field.name}${r"}"},</if>
			<#else>
			<if test="${field.name} != null and ${field.name} !='' ">${field.columnName}=${r"#{"}${field.name}${r"}"},</if>
			</#if>
		</#list>
		</trim>
         update_time = now() WHERE id = ${r"#{id}"}
    </update>
    
    <!--删除-->
    <delete id="${mapperConfig.deleteEntry.idValue}" parameterType="java.lang.Long">
    	delete from ${dataObject.tableName} where id = ${r"#{id}"}
    </delete>
    
</mapper>