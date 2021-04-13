<#include "../header.ftl"/>
<h2>Creation d'un nouveau role</h2>
<form method="post" action="create">
    <div class="form-group">
        <label for="rolename">Nom du role</label>
        <input type="text" class="form-control" name="roleName"/>
    </div>
    <div class="form-group">
        <#include "../macro/btnForm.ftl"/>
    </div>
</form>
<#include "../footer.ftl"/>