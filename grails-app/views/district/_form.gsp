<%@ page import="org.trg.District" %>



<div class="fieldcontain ${hasErrors(bean: districtInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="district.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${districtInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: districtInstance, field: 'code', 'error')} required">
	<label for="code">
		<g:message code="district.code.label" default="Code" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="code" required="" value="${districtInstance?.code}"/>
</div>

